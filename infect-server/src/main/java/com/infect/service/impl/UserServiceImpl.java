package com.infect.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.infect.constants.JwtConstant;
import com.infect.dto.ChangePasswordDTO;
import com.infect.dto.UserLoginDTO;
import com.infect.dto.system.UserBaseInfoDTO;
import com.infect.dto.system.UserPageDTO;
import com.infect.entity.Dailyhealthstatus;
import com.infect.entity.User;
import com.infect.enums.UserEnumConstants;
import com.infect.mapper.DailyhealthstatusMapper;
import com.infect.mapper.UserMapper;
import com.infect.properties.JwtProperties;
import com.infect.result.PageResult;
import com.infect.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.infect.utils.BaseContext;
import com.infect.utils.ExcelUtil;
import com.infect.utils.JwtUtil;
import com.infect.vo.UserLoginVO;
import com.infect.vo.system.ImportantUserInfoVO;
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
    private DailyhealthstatusMapper dailyhealthstatusMapper;

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        Map<String,Object> map=new HashMap<>();
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
            map.put(JwtConstant.USER_TYPE, JwtConstant.USER_TYPE_RAILWAY);
        } else if (user.getUserType().equals(UserEnumConstants.USER_TYPE_ADMIN)) {
            //系统管理员
            secretKey = jwtProperties.getAdminSecretKey();
            ttl = jwtProperties.getAdminTtl();
            map.put(JwtConstant.USER_TYPE, JwtConstant.USER_TYPE_ADMIN);
        } else if (user.getUserType().equals(UserEnumConstants.USER_TYPE_CDC_STAFF)) {
            //疾控中心工作人员
            secretKey = jwtProperties.getCdcStaffSecretKey();
            ttl = jwtProperties.getCdcStaffTtl();
            map.put(JwtConstant.USER_TYPE, JwtConstant.USER_TYPE_CDC_STAFF);
        } else if (user.getUserType().equals(UserEnumConstants.USER_TYPE_MEDICAL_STAFF)) {
            //专职医护人员
            secretKey = jwtProperties.getMedicalStaffSecretKey();
            ttl = jwtProperties.getMedicalStaffTtl();
            map.put(JwtConstant.USER_TYPE, JwtConstant.USER_TYPE_MEDICAL_STAFF);
        } else {
            return null;
        }
        //生成jwt
        map.put(JwtConstant.USER_ID,user.getUserId().toString());
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
     *
     * @param file
     * @return
     * @throws Exception
     */
    @Transactional
    @Override
    public int addManyUser(MultipartFile file) throws Exception {
        //获取excel表sheet1页的用户数据
        List<List<String>> lists = ExcelUtil.readExcelFile(file, 0);

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
                user.setIsVaccinatedForFlu(Boolean.parseBoolean(list.get(49))); // IsVaccinatedForFlu
            }
            if (list.get(50) != null && !list.get(50).isEmpty()) {
                user.setIsVaccinatedForPlague(Boolean.parseBoolean(list.get(50))); // IsVaccinatedForPlague
            }
            if (list.get(51) != null && !list.get(51).isEmpty()) {
                user.setIsVaccinatedForBCG(Boolean.parseBoolean(list.get(51))); // IsVaccinatedForFlu
            }
            if (list.get(52) != null && !list.get(52).isEmpty()) {
                user.setIsVaccinatedForHepatitis(Boolean.parseBoolean(list.get(52))); // IsVaccinatedForFlu
            }


            user.setPassword(user.getIdNumber().substring(12));

            String phoneNumber = user.getPhoneNumber();
            String idNumber = user.getIdNumber();

            //电话号码为空，或者身份证号为空，跳过该句
            if(phoneNumber == null || idNumber == null || phoneNumber.isEmpty() || idNumber.isEmpty()){
                continue;
            }

            //判断该用户是否已存在
            Integer count = userMapper.selectCountByIdNumberOrPhoneNumber(phoneNumber,idNumber);
            if(count!=0){
                continue;
            }

            listUser.add(user);
        }

        boolean flag = this.saveBatch(listUser, 500);

        if(flag) {
            return listUser.size();
        }
        return 0;
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
        page.addOrder(new OrderItem("userId",false));

        //分页查询
        Page<User> p = lambdaQuery()
                .like(name!=null && !name.isEmpty(), User::getName, name)
                .eq(phoneNumber!=null && !phoneNumber.isEmpty(), User::getPhoneNumber, phoneNumber)
                .eq(department!=null && !department.isEmpty(), User::getDepartment, department)
                .eq(specificOccupation!=null && !specificOccupation.isEmpty(), User::getSpecificOccupation, specificOccupation)
                .eq(userType!=null && !userType.isEmpty(), User::getUserType, userType)
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
        String filePath = projectDir + "/infect-server/src/main/resources/templates/个人信息导出表.xlsx";

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

    /**
     * 获取重点人员跟踪信息
     * @return
     */
    @Override
    public List<ImportantUserInfoVO> getImportantUserInfo() {

        //根据id查询用户部分信息
        List<ImportantUserInfoVO> list = userMapper.selectHasMedicalHistoryIsTrue();

        //根据id查询今日签到部分信息
        for (ImportantUserInfoVO vo:list) {
            Dailyhealthstatus dailyhealthstatus = dailyhealthstatusMapper.selectOne(
                    new LambdaQueryWrapper<Dailyhealthstatus>()
                            .eq(Dailyhealthstatus::getUserId, vo.getUserId())
                            .eq(Dailyhealthstatus::getCheckInDate, LocalDate.now())
            );

            if(dailyhealthstatus!=null){
                BeanUtil.copyProperties(dailyhealthstatus,vo);
            }
        }

        return list;
    }

    @Override
    public User getUserByBaseInfo(UserBaseInfoDTO userBaseInfoDTO) {
        String name = userBaseInfoDTO.getName();
        String phoneNumber = userBaseInfoDTO.getPhoneNumber();
        String gender = userBaseInfoDTO.getGender();
        Integer age = userBaseInfoDTO.getAge();

        //根据查询条件构造wrapper条件
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>()
                .like(name!=null, User::getName, name)
                .like(phoneNumber!=null,User::getPhoneNumber,phoneNumber)
                .eq(gender!=null,User::getGender,gender)
                .eq(age!=null,User::getAge,age);

        //根据构造条件查询对应用户数量
        Integer count = Math.toIntExact(userMapper.selectCount(lambdaQueryWrapper));

        //数量不等于1，返回失败信息
        if(count!=1){
            return null;
        }

        //查询用户信息，并返回
        return userMapper.selectOne(lambdaQueryWrapper);
    }

}
