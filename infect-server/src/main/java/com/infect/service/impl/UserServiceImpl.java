package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.infect.constants.JwtConstant;
import com.infect.dto.ChangePasswordDTO;
import com.infect.dto.UserLoginDTO;
import com.infect.dto.system.UserPageDTO;
import com.infect.entity.User;
import com.infect.enums.UserEnumConstants;
import com.infect.mapper.UserMapper;
import com.infect.properties.JwtProperties;
import com.infect.result.PageResult;
import com.infect.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.utils.BaseContext;
import com.infect.utils.ExcelUtil;
import com.infect.utils.JwtUtil;
import com.infect.vo.UserLoginVO;
import com.infect.vo.system.UserSystemInfoVO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        //根据用户手机号码和密码查询用户信息
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
                .eq(User::getPhoneNumber, userLoginDTO.getPhoneNumber())
                .eq(User::getPassword, userLoginDTO.getPassword());
        User user = userMapper.selectOne(queryWrapper);
        //判断手机号码和密码是否正确,不正确直接返回null
        if (user == null) {
            return null;
        }
        //判断账户是否可以使用，不能使用返回null
        if (!user.getIsActived()) {
            return null;
        }
        //创建UserLoginVO对象，设置属性值
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setUser(user);
        //通过身份证号判断用户是否填写个人信息
        if("".equals(user.getIdNumber()) || user.getIdNumber()==null) {
            userLoginVO.setInformationComplete(false);
        } else {
            userLoginVO.setInformationComplete(true);
        }
        //根据不同身份，生成jwt
        String secretKey = "";
        Long ttl = 0L;
        if (user.getUserType().equals(UserEnumConstants.USER_TYPE_RAILWAY_EMPLOYEE)) {
            //铁路工人
            secretKey = jwtProperties.getRailwayEmployeeSecretKey();
            ttl = jwtProperties.getRailwayEmployeeTtl();
        } else if (user.getUserType().equals(UserEnumConstants.USER_TYPE_ADMIN)) {
            //系统管理员
            secretKey = jwtProperties.getAdminSecretKey();
            ttl = jwtProperties.getAdminTtl();
        } else if (user.getUserType().equals(UserEnumConstants.USER_TYPE_CDC_STAFF)) {
            //疾控中心工作人员
            secretKey = jwtProperties.getCdcStaffSecretKey();
            ttl = jwtProperties.getCdcStaffTtl();
        } else if (user.getUserType().equals(UserEnumConstants.USER_TYPE_MEDICAL_STAFF)) {
            //专职医护人员
            secretKey = jwtProperties.getMedicalStaffSecretKey();
            ttl = jwtProperties.getMedicalStaffTtl();
        } else {
            return null;
        }
        //生成jwt
        Map<String,Object> map=new HashMap();
        map.put(JwtConstant.UserId,user.getUserId().toString());
        String jwt= JwtUtil.createJWT(secretKey,ttl,map);
        userLoginVO.setToken(jwt);
        //将密码设置为空
        userLoginVO.getUser().setPassword("hello");
        return userLoginVO;
    }

    /**
     * 修改密码
     * @param changePasswordDTO
     * @return
     */
    @Override
    public boolean changePassword(ChangePasswordDTO changePasswordDTO) {
        if (!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getConfirmPassword())) {
            return false;
        }
        //检查原密码是否正确
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUserId, BaseContext.getCurrentId())
                .eq(User::getPassword, changePasswordDTO.getOldPassword());
        Long count = userMapper.selectCount(wrapper);
        if (count == 0) {
            return false;
        }

        //修改密码为新密码
        User user = new User();
        user.setUserId(BaseContext.getCurrentId());
        user.setPassword(changePasswordDTO.getNewPassword());
        userMapper.updateById(user);

        return true;
    }

    /**
     * 将excel表中用户数据插入用户表中
     * @param multipartFile
     * @throws Exception
     */
    @Transactional
    @Override
    public void addManyUser(MultipartFile multipartFile) throws Exception {
        //获取excel表sheet1页的用户数据
        List<List<String>> lists = ExcelUtil.readExcelFile(multipartFile, 0);

        for (Object t : lists) {
            System.out.println(t);
        }

        if(1==1) return;

        //将‘是’转换为 true, ‘否’转换为false
        for (List<String> list : lists) {
            int n = list.size();
            for (int i = 0; i < n; i++) {
                list.set(i, list.get(i).trim());

                if (list.get(i).equals("是")) {
                    list.set(i, "true");
                }
                if (list.get(i).equals("否") && i!=12) {
                    list.set(i, "false");
                }
                if (list.get(i).isEmpty()) {
                    list.set(i, null);
                }

            }
        }

        //遍历lists集合，将数据封装到listUser中
        List<User> listUser = new ArrayList<>();

        int n = lists.size();
        for (int i = 1; i < n; i++) {  // 跳过第一行标题
            User user = new User();
            List<String> list = lists.get(i);

            if (list.get(1) != null && !list.get(1).isEmpty()) {
                user.setUserType(list.get(1));  // UserType
            }
            if (list.get(2) != null && !list.get(2).isEmpty()) {
                user.setName(list.get(2));  // Name
            }
            if (list.get(3) != null && !list.get(3).isEmpty()) {
                user.setGender(list.get(3));  // Gender
            }
            if (list.get(4) != null && !list.get(4).isEmpty()) {
                user.setIsPregnant(Boolean.parseBoolean(list.get(4)));  // IsPregnant
            }
            if (list.get(5) != null && !list.get(5).isEmpty()) {
                user.setPregnancyWeeks(Integer.parseInt(list.get(5)));  // PregnancyWeeks
            }
            if (list.get(6) != null && !list.get(6).isEmpty()) {
                user.setIdNumber(list.get(6));  // IDNumber
            }
            if (list.get(7) != null && !list.get(7).isEmpty()) {
                user.setAge(Integer.parseInt(list.get(7)));  // Age
            }
            if (list.get(8) != null && !list.get(8).isEmpty()) {
                user.setEthnicity(list.get(8));  // Ethnicity
            }
            if (list.get(9) != null && !list.get(9).isEmpty()) {
                user.setEducationLevel(list.get(9));  // EducationLevel
            }
            if (list.get(10) != null && !list.get(10).isEmpty()) {
                user.setWorkOnPlateauStartDate(LocalDate.parse(list.get(10)));  // WorkOnPlateauStartDate
            }
            if (list.get(11) != null && !list.get(11).isEmpty()) {
                user.setDepartment(list.get(11));  // Department
            }
            if (list.get(12) != null && !list.get(12).isEmpty()) {
                user.setSpecificOccupation(list.get(12));  // SpecificOccupation
            }
            if (list.get(13) != null && !list.get(13).isEmpty()) {
                user.setMedicalPersonnelType(list.get(13));  // MedicalPersonnelType
            }
            if (list.get(14) != null && !list.get(14).isEmpty()) {
                user.setOtherPositionName(list.get(14));  // OtherPositionName
            }
            if (list.get(15) != null && !list.get(15).isEmpty()) {
                user.setPhoneNumber(list.get(15));  // PhoneNumber
            }
            if (list.get(16) != null && !list.get(16).isEmpty()) {
                user.setOtherPhoneNumber(list.get(16));  // OtherPhoneNumber
            }
            if (list.get(17) != null && !list.get(17).isEmpty()) {
                user.setHasMedicalHistory(Boolean.parseBoolean(list.get(17)));  // HasMedicalHistory
            }
            if (list.get(18) != null && !list.get(18).isEmpty()) {
                user.setHasHypertension(Boolean.parseBoolean(list.get(18)));  // HasHypertension
            }
            if (list.get(19) != null && !list.get(19).isEmpty()) {
                user.setHasDiabetes(Boolean.parseBoolean(list.get(19)));  // HasDiabetes
            }
            if (list.get(20) != null && !list.get(20).isEmpty()) {
                user.setHasHyperlipidemia(Boolean.parseBoolean(list.get(20)));  // HasHyperlipidemia
            }
            if (list.get(21) != null && !list.get(21).isEmpty()) {
                user.setHasHyperuricemia(Boolean.parseBoolean(list.get(21)));  // HasHyperuricemia
            }
            if (list.get(22) != null && !list.get(22).isEmpty()) {
                user.setHasCoronaryHeartDisease(Boolean.parseBoolean(list.get(22)));  // HasCoronaryHeartDisease
            }
            if (list.get(23) != null && !list.get(23).isEmpty()) {
                user.setHasStroke(Boolean.parseBoolean(list.get(23)));  // HasStroke
            }
            if (list.get(24) != null && !list.get(24).isEmpty()) {
                user.setHasOtherCardiovascularDiseases(Boolean.parseBoolean(list.get(24)));  // HasOtherCardiovascularDiseases
            }
            if (list.get(25) != null && !list.get(25).isEmpty()) {
                user.setHasAsthma(Boolean.parseBoolean(list.get(25)));  // HasAsthma
            }
            if (list.get(26) != null && !list.get(26).isEmpty()) {
                user.setHasCOPD(Boolean.parseBoolean(list.get(26)));  // HasCOPD
            }
            if (list.get(27) != null && !list.get(27).isEmpty()) {
                user.setHasPepticUlcer(Boolean.parseBoolean(list.get(27)));  // HasPepticUlcer
            }
            if (list.get(28) != null && !list.get(28).isEmpty()) {
                user.setHasMalignantTumor(Boolean.parseBoolean(list.get(28)));  // HasMalignantTumor
            }
            if (list.get(29) != null && !list.get(29).isEmpty()) {
                user.setHasLungCancer(Boolean.parseBoolean(list.get(29)));  // HasLungCancer
            }
            if (list.get(30) != null && !list.get(30).isEmpty()) {
                user.setHasOtherCancer(Boolean.parseBoolean(list.get(30)));  // HasOtherCancer
            }
            if (list.get(31) != null && !list.get(31).isEmpty()) {
                user.setOtherCancerName(list.get(31));  // OtherCancerName
            }
            if (list.get(32) != null && !list.get(32).isEmpty()) {
                user.setHasSevereMentalDisorders(Boolean.parseBoolean(list.get(32)));  // HasSevereMentalDisorders
            }
            if (list.get(33) != null && !list.get(33).isEmpty()) {
                user.setHasTuberculosis(Boolean.parseBoolean(list.get(33)));  // HasTuberculosis
            }
            if (list.get(34) != null && !list.get(34).isEmpty()) {
                user.setHasHepatitis(Boolean.parseBoolean(list.get(34)));  // HasHepatitis
            }
            if (list.get(35) != null && !list.get(35).isEmpty()) {
                user.setHasOccupationalDisease(Boolean.parseBoolean(list.get(35)));  // HasOccupationalDisease
            }
            if (list.get(36) != null && !list.get(36).isEmpty()) {
                user.setHasChronicKidneyDisease(Boolean.parseBoolean(list.get(36)));  // HasChronicKidneyDisease
            }
            if (list.get(37) != null && !list.get(37).isEmpty()) {
                user.setHasChronicLiverDisease(Boolean.parseBoolean(list.get(37)));  // HasChronicLiverDisease
            }
            if (list.get(38) != null && !list.get(38).isEmpty()) {
                user.setHasImmunodeficiency(Boolean.parseBoolean(list.get(38)));  // HasImmunodeficiency
            }
            if (list.get(39) != null && !list.get(39).isEmpty()) {
                user.setHasTyphus(Boolean.parseBoolean(list.get(39)));  // HasTyphus
            }
            if (list.get(40) != null && !list.get(40).isEmpty()) {
                user.setIsPostpartumInSixWeeks(Boolean.parseBoolean(list.get(40)));  // IsPostpartumInSixWeeks
            }
            if (list.get(41) != null && !list.get(41).isEmpty()) {
                user.setHasDustExposure(Boolean.parseBoolean(list.get(41)));  // HasDustExposure
            }
            if (list.get(42) != null && !list.get(42).isEmpty()) {
                user.setHasOtherDiseases(Boolean.parseBoolean(list.get(42)));  // HasOtherDiseases
            }
            if (list.get(43) != null && !list.get(43).isEmpty()) {
                user.setOtherDiseasesName(list.get(43));  // OtherDiseasesName
            }
            if (list.get(44) != null && !list.get(44).isEmpty()) {
                user.setSmokingStatus(list.get(44));  // SmokingStatus
            }
            if (list.get(45) != null && !list.get(45).isEmpty()) {
                user.setDrinkingStatus(list.get(45));  // DrinkingStatus
            }
            if (list.get(46) != null && !list.get(46).isEmpty()) {
                user.setHeight(Integer.parseInt(list.get(46)));  // Height
            }
            if (list.get(47) != null && !list.get(47).isEmpty()) {
                user.setWeight(Integer.parseInt(list.get(47)));  // Weight
            }
            if (list.get(48) != null && !list.get(48).isEmpty()) {
                user.setIsVaccinatedForCOVID(Boolean.parseBoolean(list.get(48)));  // IsVaccinatedForCOVID
            }
            if (list.get(49) != null && !list.get(49).isEmpty()) {
                user.setIsVaccinatedForFlu(Boolean.parseBoolean(list.get(49)));
            }

            user.setPassword(user.getIdNumber().substring(12));
            listUser.add(user);
        }

        this.saveBatch(listUser, 500);
    }

    /**
     * 修改用户账号状态
     * @param userId
     */
    @Override
    public void changeUserActive(Integer userId) {
        //查询用户账号状态
        Boolean status = userMapper.selectIsActivedByUserId(userId);

        //修改用户账号状态
        if(status) {
            status=false;
        }
        else {
            status=true;
        }

        userMapper.updateIsActivedByUserId(userId, status);
    }

    /**
     * 将用户密码初始化为身份证后六位
     * @param userId
     */
    @Override
    public void initPassword(Integer userId) {
        //查询用户身份号
        String idNumber=userMapper.selectIdNumberByUserId(userId);

        //修改用户密码为身份找号后六位
        userMapper.updateIdNumberByUserId(idNumber.substring(12), userId);
    }

    /**
     * 分页查询用户信息
     * @param userPageDTO
     * @return
     */
    @Override
    public PageResult<UserSystemInfoVO> queryUserspage(UserPageDTO userPageDTO) {
        String name = userPageDTO.getName();
        String phoneNumber = userPageDTO.getPhoneNumber();
        String department = userPageDTO.getDepartment();
        String specificOccupation = userPageDTO.getSpecificOccupation();
        String userType = userPageDTO.getUserType();

        //构建分页条件
        Page<User> page = Page.of(userPageDTO.getPageNo(), userPageDTO.getPageSize());

        //分页查询
        Page<User> p = lambdaQuery()
                .like(name!=null, User::getName, name)
                .eq(phoneNumber!=null, User::getPhoneNumber, phoneNumber)
                .eq(department!=null, User::getDepartment, department)
                .eq(specificOccupation!=null, User::getSpecificOccupation, specificOccupation)
                .eq(userType!=null, User::getUserType, userType)
                .page(page);

        //封装VO结果
        PageResult<UserSystemInfoVO> pageResult = new PageResult<>();
        pageResult.setTotal(p.getTotal());

        List<UserSystemInfoVO> list=new ArrayList<>();
        for (Object t:p.getRecords()) {
            list.add(BeanUtil.copyProperties(t,UserSystemInfoVO.class));
        }
        pageResult.setRecords(list);

        //返回
        return pageResult;
    }

    /**
     * 将用户信息导出为excel表(利用工具)
     * @param response
     */
    public void queryAllUserToExcel(HttpServletResponse response){
        String projectDir = System.getProperty("user.dir");
        String filePath = projectDir + "\\infect-server\\src\\main\\resources\\templates\\个人信息导出表.xlsx";

        List<User> listUser = userMapper.selectList(null);
        List<List<Object>> listList = new ArrayList<>();

        for (Object obj:listUser) {
            List<Object> temp = new ArrayList<>();
            temp.add(obj);
            listList.add(temp);
        }

        XSSFWorkbook excel = ExcelUtil.getExcelFile(response, "个人信息导出表.xlsx", filePath
                , 1,1,52
                ,1,1
                ,listList);

        try {
            ServletOutputStream out = response.getOutputStream();
            excel.write(out);

            excel.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //老方法
//    /**
//     * 将用户信息导出为excel表
//     * @param response
//     */
//    @Override
//    public void queryAllUserToExcel(HttpServletResponse response) {
//        //0.设置 HTTP 响应头，指定文件名和 MIME 类型
//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//        response.setHeader("Content-Disposition", "attachment; filename=\"users.xlsx\"");
//
//        //1.查询数据库，获取用户信息
//        List<User> list = userMapper.selectList(null);
//
//        //2.通过POI将数据写入到EXcel文件
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("templates/个人信息导出表.xlsx");
//
//        try {
//            // 根据模板创建一个新Excel文件
//            XSSFWorkbook excel = new XSSFWorkbook(in);
//            XSSFSheet sheet = excel.getSheet("个人信息导出表");
//
//            // 填充数据
//            int n = list.size();
//            XSSFRow row;
//            User user;
//
//            for (int i = 0; i < n; i++) {
//                row = sheet.getRow(i + 1);
//                // 如果当前行为空，需要先创建该行
//                if (row == null) {
//                    row = sheet.createRow(i + 1);
//                }
//                user = list.get(i);
//
//                for (int j=0; j<53;j++){
//                    if(row.getCell(j)==null){
//                        row.createCell(j);
//                    }
//                }
//
//                // 序号
//                row.createCell(0).setCellValue(i + 1);
//
//// 用户类型
//                if (user.getUserType() != null) {
//                    row.createCell(1).setCellValue(user.getUserType());
//                }
//
//// 姓名
//                if (user.getName() != null) {
//                    row.createCell(2).setCellValue(user.getName());
//                }
//
//// 性别
//                if (user.getGender() != null) {
//                    row.createCell(3).setCellValue(user.getGender());
//                }
//
//// 是否怀孕
//                row.createCell(4).setCellValue(user.getIsPregnant() != null && user.getIsPregnant() ? "是" : "否");
//
//// 怀孕周数
//                if (user.getPregnancyWeeks() != null) {
//                    row.createCell(5).setCellValue(user.getPregnancyWeeks().toString());
//                } else {
//                    row.createCell(5).setCellValue("");
//                }
//
//// 身份证号
//                if (user.getIdNumber() != null) {
//                    row.createCell(6).setCellValue(user.getIdNumber());
//                }
//
//// 年龄
//                if (user.getAge() != null) {
//                    row.createCell(7).setCellValue(user.getAge());
//                }
//
//// 民族
//                if (user.getEthnicity() != null) {
//                    row.createCell(8).setCellValue(user.getEthnicity());
//                }
//
//// 教育水平
//                if (user.getEducationLevel() != null) {
//                    row.createCell(9).setCellValue(user.getEducationLevel());
//                }
//
//// 在高原工作的开始日期
//                if (user.getWorkOnPlateauStartDate() != null) {
//                    row.createCell(10).setCellValue(user.getWorkOnPlateauStartDate().toString());
//                } else {
//                    row.createCell(10).setCellValue("");
//                }
//
//// 部门
//                if (user.getDepartment() != null) {
//                    row.createCell(11).setCellValue(user.getDepartment());
//                }
//
//// 特殊职业
//                if (user.getSpecificOccupation() != null) {
//                    row.createCell(12).setCellValue(user.getSpecificOccupation());
//                }
//
//// 医务人员类别
//                if (user.getMedicalPersonnelType() != null) {
//                    row.createCell(13).setCellValue(user.getMedicalPersonnelType());
//                }
//
//// 其他职位名称
//                if (user.getOtherPositionName() != null) {
//                    row.createCell(14).setCellValue(user.getOtherPositionName());
//                }
//
//// 电话号码
//                if (user.getPhoneNumber() != null) {
//                    row.createCell(15).setCellValue(user.getPhoneNumber());
//                }
//
//// 其他电话号码
//                if (user.getOtherPhoneNumber() != null) {
//                    row.createCell(16).setCellValue(user.getOtherPhoneNumber());
//                }
//
//// 是否有既往病史
//                row.createCell(17).setCellValue(user.getHasMedicalHistory() != null && user.getHasMedicalHistory() ? "是" : "否");
//
//// 是否有高血压
//                row.createCell(18).setCellValue(user.getHasHypertension() != null && user.getHasHypertension() ? "是" : "否");
//
//// 是否有糖尿病
//                row.createCell(19).setCellValue(user.getHasDiabetes() != null && user.getHasDiabetes() ? "是" : "否");
//
//// 是否有高脂血症
//                row.createCell(20).setCellValue(user.getHasHyperlipidemia() != null && user.getHasHyperlipidemia() ? "是" : "否");
//
//// 是否有高尿酸血症
//                row.createCell(21).setCellValue(user.getHasHyperuricemia() != null && user.getHasHyperuricemia() ? "是" : "否");
//
//// 是否有冠心病
//                row.createCell(22).setCellValue(user.getHasCoronaryHeartDisease() != null && user.getHasCoronaryHeartDisease() ? "是" : "否");
//
//// 是否有中风
//                row.createCell(23).setCellValue(user.getHasStroke() != null && user.getHasStroke() ? "是" : "否");
//
//// 是否有其他心血管疾病
//                row.createCell(24).setCellValue(user.getHasOtherCardiovascularDiseases() != null && user.getHasOtherCardiovascularDiseases() ? "是" : "否");
//
//// 是否有哮喘
//                row.createCell(25).setCellValue(user.getHasAsthma() != null && user.getHasAsthma() ? "是" : "否");
//
//// 是否有慢阻肺
//                row.createCell(26).setCellValue(user.getHasCOPD() != null && user.getHasCOPD() ? "是" : "否");
//
//// 是否有消化性溃疡
//                row.createCell(27).setCellValue(user.getHasPepticUlcer() != null && user.getHasPepticUlcer() ? "是" : "否");
//
//// 是否有恶性肿瘤
//                row.createCell(28).setCellValue(user.getHasMalignantTumor() != null && user.getHasMalignantTumor() ? "是" : "否");
//
//// 是否有肺癌
//                row.createCell(29).setCellValue(user.getHasLungCancer() != null && user.getHasLungCancer() ? "是" : "否");
//
//// 是否有其他癌症
//                row.createCell(30).setCellValue(user.getHasOtherCancer() != null && user.getHasOtherCancer() ? "是" : "否");
//
//// 其他癌症名称
//                if (user.getOtherCancerName() != null) {
//                    row.createCell(31).setCellValue(user.getOtherCancerName());
//                }
//
//// 是否有严重精神障碍
//                row.createCell(32).setCellValue(user.getHasSevereMentalDisorders() != null && user.getHasSevereMentalDisorders() ? "是" : "否");
//
//// 是否有结核病
//                row.createCell(33).setCellValue(user.getHasTuberculosis() != null && user.getHasTuberculosis() ? "是" : "否");
//
//// 是否有肝炎
//                row.createCell(34).setCellValue(user.getHasHepatitis() != null && user.getHasHepatitis() ? "是" : "否");
//
//// 是否有职业病
//                row.createCell(35).setCellValue(user.getHasOccupationalDisease() != null && user.getHasOccupationalDisease() ? "是" : "否");
//
//// 是否有慢性肾病
//                row.createCell(36).setCellValue(user.getHasChronicKidneyDisease() != null && user.getHasChronicKidneyDisease() ? "是" : "否");
//
//// 是否有慢性肝病
//                row.createCell(37).setCellValue(user.getHasChronicLiverDisease() != null && user.getHasChronicLiverDisease() ? "是" : "否");
//
//// 是否有免疫缺陷
//                row.createCell(38).setCellValue(user.getHasImmunodeficiency() != null && user.getHasImmunodeficiency() ? "是" : "否");
//
//// 是否有斑疹伤寒
//                row.createCell(39).setCellValue(user.getHasTyphus() != null && user.getHasTyphus() ? "是" : "否");
//
//// 是否在六周内产后
//                row.createCell(40).setCellValue(user.getIsPostpartumInSixWeeks() != null && user.getIsPostpartumInSixWeeks() ? "是" : "否");
//
//// 是否有粉尘暴露
//                row.createCell(41).setCellValue(user.getHasDustExposure() != null && user.getHasDustExposure() ? "是" : "否");
//
//// 是否有其他疾病
//                row.createCell(42).setCellValue(user.getHasOtherDiseases() != null && user.getHasOtherDiseases() ? "是" : "否");
//
//// 其他疾病名称
//                if (user.getOtherDiseasesName() != null) {
//                    row.createCell(43).setCellValue(user.getOtherDiseasesName());
//                }
//
//// 吸烟状态
//                if (user.getSmokingStatus() != null) {
//                    row.createCell(44).setCellValue(user.getSmokingStatus());
//                }
//
//// 饮酒状态
//                if (user.getDrinkingStatus() != null) {
//                    row.createCell(45).setCellValue(user.getDrinkingStatus());
//                }
//
//// 身高
//                if (user.getHeight() != null) {
//                    row.createCell(46).setCellValue(user.getHeight());
//                }
//
//// 体重
//                if (user.getWeight() != null) {
//                    row.createCell(47).setCellValue(user.getWeight());
//                }
//
//// 是否接种新冠疫苗
//                row.createCell(48).setCellValue(user.getIsVaccinatedForCOVID() != null && user.getIsVaccinatedForCOVID() ? "是" : "否");
//
//// 是否接种流感疫苗
//                row.createCell(49).setCellValue(user.getIsVaccinatedForFlu() != null && user.getIsVaccinatedForFlu() ? "是" : "否");
//
//// 是否接种鼠疫疫苗
//                row.createCell(50).setCellValue(user.getIsVaccinatedForPlague() != null && user.getIsVaccinatedForPlague() ? "是" : "否");
//
//// 是否接种卡介苗
//                row.createCell(51).setCellValue(user.getIsVaccinatedForBCG() != null && user.getIsVaccinatedForBCG() ? "是" : "否");
//
//// 是否接种肝炎疫苗
//                row.createCell(52).setCellValue(user.getIsVaccinatedForHepatitis() != null && user.getIsVaccinatedForHepatitis() ? "是" : "否");
//
//            }
//
//            //3.通过输出流将Excel文件下载到客户端中
//            ServletOutputStream out=response.getOutputStream();
//            excel.write(out);
//
//            //4.关闭资源
//            in.close();
//            out.close();
//            excel.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
