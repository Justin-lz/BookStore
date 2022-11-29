package org.bsm.bsm.service;

import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.entity.UserPass;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    public UserInfo login(UserPass userPass);

}
