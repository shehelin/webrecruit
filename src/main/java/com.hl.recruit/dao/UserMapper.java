package com.hl.recruit.dao;

import com.hl.recruit.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserMapper interface
 *
 * @author hl.she
 * @date 2019/03/08
 */
@Repository
public interface UserMapper {

     /**
     * 用做登陆校验
     * @param user
     * @return
     */
     UserEntity login(UserEntity user);


    /**
     * 个人信息查询
     * @param user
     * @return
     */
     UserEntity queryUserById(UserEntity user);

    /**
     * register
     * @param user
     * @return
     */
    int insertUser(UserEntity user);

    /**
     * 修改信息
     * @param user
     * @return
     */
    int updateUserById(UserEntity user);

    /**
     * 修改密码
     * @param user
     * @return
     */
    int updatePwd(UserEntity user);

    /**
     * 注销用户
     * @param user
     * @return
     */
    int deleteUserById(UserEntity user);

    /**
     * 用户信息
     * @param userEntity
     * @return
     */
    UserEntity queryUser(UserEntity userEntity);
}
