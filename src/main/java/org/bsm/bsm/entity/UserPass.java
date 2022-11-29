package org.bsm.bsm.entity;

public class UserPass {//用来完成登录检查的
    private Integer Uid;
    private String Uname;
    private String UPword;


    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUPword() {
        return UPword;
    }

    public void setUPword(String UPword) {
        this.UPword = UPword;
    }
}
