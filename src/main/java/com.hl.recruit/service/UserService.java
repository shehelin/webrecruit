package com.hl.recruit.service;


import com.hl.recruit.entity.UserEntity;

import java.util.List;

/**
 * UserService interface
 *
 * @author hl.she
 * @date 2019/03/08
 */
public interface UserService {

    /**
     * query
     * @param user
     * @return
     */
    UserEntity queryUserById(UserEntity user);

    /**
     * login
     * @param user
     * @return
     */
    UserEntity login(UserEntity user);

    /**
     * register
     * @param user
     * @return
     */
    boolean reigisterUser(UserEntity user);

    /**
     * 修改信息
     * @param user
     * @return
     */
    boolean updateUserById(UserEntity user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    boolean updatePwd(UserEntity user);

    /**
     * 注销用户
     * @param user
     * @return
     */
    boolean deleteUserById(UserEntity user);
}
