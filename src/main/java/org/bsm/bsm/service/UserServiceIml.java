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

    @Override
    public boolean checkUnique(UserPass userPass) {
        UserPass userPassGet = userPassMapper.checkUserUnique(userPass);
        return userPassGet == null; //判断用户是否存在
    }

    @Override
    public Integer newUser(UserPass userPass) {
        return userPassMapper.registerUserPass(userPass);
    }

    @Override
    public UserInfo updateUser( Integer Uid, String Ubirth, String Usex, String Uaddress, String Uphone) {

        UserInfo userInfo = new UserInfo();
        userInfo.setUaddress(Uaddress);
        userInfo.setUid(Uid);
        userInfo.setUphone(Uphone);
        userInfo.setUbirth(Ubirth);
        userInfo.setUsex(Usex);
        try {
            userInfoMapper.updateUserInfo(userInfo);

            return userInfo;
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }

    }
}
