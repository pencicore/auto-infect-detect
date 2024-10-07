package com.infect.service;

import com.infect.dto.ChangePasswordDTO;
import com.infect.dto.UserLoginDTO;
import com.infect.dto.system.UserBaseInfoDTO;
import com.infect.dto.system.UserPageDTO;
import com.infect.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.result.PageResult;
import com.infect.vo.UserLoginVO;
import com.infect.vo.system.ImportantUserInfoVO;
import com.infect.vo.system.UserSystemInfoVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-08-24
 */
public interface IUserService extends IService<User> {

    UserLoginVO login(UserLoginDTO userLoginDTO);

    boolean changePassword(ChangePasswordDTO changePasswordDTO);

    int addManyUser(MultipartFile multipartFile) throws Exception;

    void changeUserActive(Integer userId);

    void initPassword(Integer userId);

    PageResult<UserSystemInfoVO> queryUserspage(UserPageDTO userPageDTO);

    void queryAllUserToExcel(HttpServletResponse response);

    List<ImportantUserInfoVO> getImportantUserInfo();

    User getUserByBaseInfo(UserBaseInfoDTO userBaseInfoDTO);
}
