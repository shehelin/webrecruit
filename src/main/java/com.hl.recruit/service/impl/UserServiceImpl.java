package com.hl.recruit.service.impl;

import com.hl.recruit.dao.UserMapper;
import com.hl.recruit.entity.UserEntity;
import com.hl.recruit.service.UserService;
import com.hl.recruit.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserServiceImpl class
 *
 * @author hl.she
 * @date 2019/03/08
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    UserMapper userMapper ;

    @Override
    public UserEntity queryUserById(UserEntity user) {
        try{
            return userMapper.queryUserById(user);
        }catch (Exception e){
            LOGGER.info("exceptionInfo:"+e.getMessage());
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public UserEntity login(UserEntity user) {
        try{
            return userMapper.login(user);
        }catch (Exception e){
            LOGGER.info("exceptionInfo:"+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean reigisterUser(UserEntity user) {
        user.setCreateTime(DateUtil.getCurrentTime());
        int count = userMapper.insertUser(user);
        if(count > 0){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUserById(UserEntity user) {
        int count = userMapper.updateUserById(user);
        if (count > 0 ){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updatePwd(UserEntity user) {
        int count =  userMapper.updatePwd(user);
        if (count > 0 ){
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUserById(UserEntity user) {
        int count = userMapper.deleteUserById(user);
        if (count > 0 ){
            return true;
        }
        return false;
    }

    @Override
    public UserEntity queryUser(UserEntity userEntity) {
        return userMapper.queryUser(userEntity);
    }
}
