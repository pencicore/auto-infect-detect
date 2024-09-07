package com.infect.service;

import com.infect.dto.ChangePasswordDTO;
import com.infect.dto.UserLoginDTO;
import com.infect.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.infect.vo.UserLoginVO;
import org.springframework.web.multipart.MultipartFile;

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

    void addManyUser(MultipartFile multipartFile) throws Exception;

    void changeUserActive(Integer userId);

    void initPassword(Integer userId);
}
