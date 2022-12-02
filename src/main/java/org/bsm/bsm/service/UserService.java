package org.bsm.bsm.service;

import io.swagger.models.auth.In;
import org.bsm.bsm.entity.UserInfo;
import org.bsm.bsm.entity.UserPass;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    public UserInfo login(UserPass userPass);

    public boolean checkUnique(UserPass userPass);

    public Integer newUser(UserPass userPass);

    public UserInfo updateUser(Integer Uid, String Ubirth, String Usex, String Uaddress, String Uphone);

}
