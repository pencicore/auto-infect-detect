package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.infect.dto.system.DiseaseLearningMaterialsPageDTO;
import com.infect.dto.system.LearningMaterialDTO;
import com.infect.dto.system.LearningMaterialUpdateDTO;
import com.infect.entity.Diseaselearningmaterials;
import com.infect.entity.Materiallearningrecords;
import com.infect.entity.Userfeedback;
import com.infect.enums.DiseaseLearningMaterialsEnumConstants;
import com.infect.mapper.DiseaselearningmaterialsMapper;
import com.infect.mapper.DiseasetypeMapper;
import com.infect.mapper.MateriallearningrecordsMapper;
import com.infect.properties.PathProperties;
import com.infect.result.PageResult;
import com.infect.service.IDiseaselearningmaterialsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.vo.system.DiseaseLearningMaterialsPageVO;
import com.infect.vo.system.UserFeedBackPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-10-02
 */
@Service
public class DiseaselearningmaterialsServiceImpl extends ServiceImpl<DiseaselearningmaterialsMapper, Diseaselearningmaterials> implements IDiseaselearningmaterialsService {

    @Autowired
    private DiseaselearningmaterialsMapper diseaselearningmaterialsMapper;

    @Autowired
    private MateriallearningrecordsMapper materiallearningrecordsMapper;

    @Autowired
    private PathProperties pathProperties;

    @Autowired
    private DiseasetypeMapper diseasetypeMapper;

    /**
     * 根据疾病类型名，分页查询疾病防控宣传资料
     * @param diseaseLearningMaterialsPageDTO
     * @return
     */
    @Override
    public PageResult<DiseaseLearningMaterialsPageVO> pageSelectDiseaseLearningMaterials(DiseaseLearningMaterialsPageDTO diseaseLearningMaterialsPageDTO) {

        String diseaseTypeName = diseaseLearningMaterialsPageDTO.getDiseaseTypeName();

        //构造分页条件
        Page<Diseaselearningmaterials> page = Page.of(diseaseLearningMaterialsPageDTO.getPageNo(),diseaseLearningMaterialsPageDTO.getPageSize());
        page.addOrder(new OrderItem("SequenceNumber",false));

        //分页查询
        Page<Diseaselearningmaterials> p = lambdaQuery()
                .eq(Diseaselearningmaterials::getDiseaseTypeName, diseaseTypeName)
                .page(page);

        //封装VO结果
        PageResult<DiseaseLearningMaterialsPageVO> pageResult = new PageResult<>();

        List<DiseaseLearningMaterialsPageVO> list = new ArrayList<>();
        for(Diseaselearningmaterials diseaselearningmaterials:p.getRecords()){
            DiseaseLearningMaterialsPageVO diseaseLearningMaterialsPageVO = new DiseaseLearningMaterialsPageVO();

            BeanUtil.copyProperties(diseaselearningmaterials, diseaseLearningMaterialsPageVO);

            diseaseLearningMaterialsPageVO.setStudyCount(
                    materiallearningrecordsMapper.selectCount(
                            new LambdaQueryWrapper<Materiallearningrecords>()
                                    .eq(Materiallearningrecords::getMaterialId, diseaselearningmaterials.getMaterialId())
                    )
            );
            list.add(diseaseLearningMaterialsPageVO);
        }

        pageResult.setRecords(list);
        pageResult.setTotal(p.getTotal());

        //返回
        return pageResult;
    }

    /**
     * 添加疾病防控宣传资料（包含文件）
     * @param learningMaterialDTO
     */
    @Override
    public void saveMaterial(LearningMaterialDTO learningMaterialDTO) {
        Diseaselearningmaterials diseaselearningmaterials = new Diseaselearningmaterials();
        String materialType = learningMaterialDTO.getMaterialType();

        //设置学习材料标题，学习材料，学习材料发布时间
        diseaselearningmaterials.setTitle(learningMaterialDTO.getTitle());
        diseaselearningmaterials.setMaterialType(materialType);
        diseaselearningmaterials.setPublishDate(LocalDateTime.now());
        diseaselearningmaterials.setIsDeleted(false);

        //设置相关疾病名称和id（查询数据库）
        diseaselearningmaterials.setDiseaseTypeName(learningMaterialDTO.getDiseaseTypeName());
        diseaselearningmaterials.setDiseaseTypeId(
                diseasetypeMapper.selectIdByName(learningMaterialDTO.getDiseaseTypeName())
        );

        //设置用于排序的序号：当前数据量+1
        diseaselearningmaterials.setSequenceNumber(
                1 + Math.toIntExact(diseaselearningmaterialsMapper.selectCount(null))
        );

        //如果学习材料类型是网页链接，设置信息后直接上传
        if (materialType.equals(DiseaseLearningMaterialsEnumConstants.LINK)){
            //设置网页连接信息，保存信息到数据库
            diseaselearningmaterials.setLink(learningMaterialDTO.getLink());
            diseaselearningmaterialsMapper.insert(diseaselearningmaterials);
        }
        //如果是'图片', '文章', '视频'，需上传文件到本地，再将文件路径上传到数据库
        if (materialType.equals(DiseaseLearningMaterialsEnumConstants.PICTURE)
        || materialType.equals(DiseaseLearningMaterialsEnumConstants.VIDEO)
        || materialType.equals(DiseaseLearningMaterialsEnumConstants.TEXT)){
            String filePath = this.saveLearningMaterialFile(learningMaterialDTO.getFile());

            //判断是否保存成功
            if(filePath == null) {
                return;
            }

            //设置文件地址信息，保存信息到数据库
            diseaselearningmaterials.setFilePath(filePath);
            diseaselearningmaterialsMapper.insert(diseaselearningmaterials);
        }
    }

    /**
     * 根据id修改疾病防控宣传资料
     * @param learningMaterialUpdateDTO
     */
    @Override
    public void updateMaterialById(LearningMaterialUpdateDTO learningMaterialUpdateDTO) {
        Diseaselearningmaterials diseaselearningmaterials = BeanUtil.copyProperties(learningMaterialUpdateDTO, Diseaselearningmaterials.class);

        //当有文件更新时
        if(learningMaterialUpdateDTO.getFile()!=null){
            String filePath = this.saveLearningMaterialFile(learningMaterialUpdateDTO.getFile());

            //判断是否保存成功
            if(filePath == null) {
                return;
            }

            diseaselearningmaterials.setFilePath(filePath);
        }

        //更新信息
        diseaselearningmaterialsMapper.updateById(diseaselearningmaterials);
    }

    /**
     * 禁用/启用疾病防控宣传资料
     * @param materialId
     * @param isDelete
     */
    @Override
    public void startOrStopMaterial(Integer materialId, Boolean isDelete) {
        Diseaselearningmaterials diseaselearningmaterials = new Diseaselearningmaterials();
        diseaselearningmaterials.setIsDeleted(isDelete);
        diseaselearningmaterials.setMaterialId(materialId);
        if (isDelete){
            diseaselearningmaterials.setDeletedDate(LocalDateTime.now());
        }
        diseaselearningmaterialsMapper.updateById(diseaselearningmaterials);
    }

    /**
     * 根据id，升/降序，交换排序顺序
     * @param sequenceNumber
     * @param isUp
     */
    @Override
    @Transactional
    public void upOrdownMaterialSequenceNumber(Integer sequenceNumber, Boolean isUp) {
        //根据isUp找到小于/大于排序值的排序值中差值最小的一个排序值
        Integer sequenceNumberNext;
        if(isUp){
            sequenceNumberNext = diseaselearningmaterialsMapper.selectSequenceNumberNextUp(sequenceNumber);
        }
        else {
            sequenceNumberNext = diseaselearningmaterialsMapper.selectSequenceNumberNextDown(sequenceNumber);
        }

        if(sequenceNumberNext == null){
            return;
        }

        //交换两者的排序值
        diseaselearningmaterialsMapper.updateSequenceNumberAndSequenceNumber(sequenceNumber,-1);
        diseaselearningmaterialsMapper.updateSequenceNumberAndSequenceNumber(sequenceNumberNext,sequenceNumber);
        diseaselearningmaterialsMapper.updateSequenceNumberAndSequenceNumber(-1,sequenceNumberNext);
    }

    /**
     * 保存文件到本地
     * @param file
     * @return
     */
    private String saveLearningMaterialFile(MultipartFile file){
        // 跳过空文件
        if (file.isEmpty()) {
            return null;
        }

        // 获取程序的当前工作目录
        String currentDir = System.getProperty("user.dir");

        // 定义保存文件的目录
        String saveDir = currentDir + File.separator + pathProperties.getDiseaseLearningMaterialPath();

        // 创建保存目录
        File directory = new File(saveDir);
        if (!directory.exists()) {
            directory.mkdirs(); // 创建目录
        }

        // 为文件名添加UUID前缀
        String originalFileName = file.getOriginalFilename();
        String fileExtension = originalFileName != null ? originalFileName.substring(originalFileName.lastIndexOf('.')) : "";
        String uniqueFileName = UUID.randomUUID() + fileExtension;

        // 将文件保存到指定目录
        File destinationFile = new File(directory, uniqueFileName);
        try {
            file.transferTo(destinationFile);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file", e);
        }

        return File.separator+uniqueFileName;
    }
}