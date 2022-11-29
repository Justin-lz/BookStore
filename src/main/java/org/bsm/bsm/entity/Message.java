package org.bsm.bsm.entity;

import io.swagger.models.auth.In;

public class Message {
    private Integer Mid;
    private String Uname;
    private String Mword;
    private String Mtime;

    public Integer getMid() {
        return Mid;
    }

    public void setMid(Integer mid) {
        Mid = mid;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getMword() {
        return Mword;
    }

    public void setMword(String mword) {
        Mword = mword;
    }

    public String getMtime() {
        return Mtime;
    }

    public void setMtime(String mtime) {
        Mtime = mtime;
    }
}
