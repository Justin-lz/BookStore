package org.bsm.bsm.entity;

import io.swagger.models.auth.In;
import javax.xml.crypto.Data;
import java.util.Date;


public class Message {
    private Integer Mid;
    private String Uname;
    private String Mword;
    private Date Mtime;
    private Integer Uid;

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

    public Date getMtime() {
        return Mtime;
    }

    public void setMtime(Date mtime) {
        Mtime = mtime;
    }

    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }
}
