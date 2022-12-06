package org.bsm.bsm.entity;


import java.util.Date;
import java.util.List;

public class Record {
    private Integer Rid;
    private Date Rtime;
    private Integer Aid;
    private Integer Uid;
    private Float Rprice;
    private String Rcheck;
    private String Rdeliever;
    private String Rreceive;

    private String Rdiscount;

    private List<History> histories;

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }

    public Date getRtime() {
        return Rtime;
    }

    public void setRtime(Date rtime) {
        Rtime = rtime;
    }

    public Integer getAid() {
        return Aid;
    }

    public void setAid(Integer aid) {
        Aid = aid;
    }

    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }

    public Float getRprice() {
        return Rprice;
    }

    public void setRprice(Float rprice) {
        Rprice = rprice;
    }

    public String getRcheck() {
        return Rcheck;
    }

    public void setRcheck(String rcheck) {
        Rcheck = rcheck;
    }

    public String getRdeliever() {
        return Rdeliever;
    }

    public void setRdeliever(String rdeliever) {
        Rdeliever = rdeliever;
    }

    public String getRreceive() {
        return Rreceive;
    }

    public void setRreceive(String rreceive) {
        Rreceive = rreceive;
    }

    public String getRdiscount() {
        return Rdiscount;
    }

    public void setRdiscount(String rdiscount) {
        Rdiscount = rdiscount;
    }
}
