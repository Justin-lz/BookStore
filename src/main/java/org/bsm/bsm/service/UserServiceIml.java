package org.bsm.bsm.service;

import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.entity.UserPass;
import org.bsm.bsm.mapper.UserInfoMapper;
import org.bsm.bsm.mapper.UserPassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceIml implements UserService{

    @Autowired
    UserPassMapper userPassMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfo login(UserPass userPass) {
        UserPass userPassGet = userPassMapper.checkUserPass(userPass);
        if (userPassGet==null) return null; //判断用户是否存在
        else {
            return userInfoMapper.getUserInfo(userPassGet.getUid());
        }


    }


}
