package org.bsm.bsm.entity;


public class History {
    private Integer Rid;
    private Integer Bid;
    private Integer count;

    private String Bname;

    public String getBname() {
        return Bname;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }

    public Integer getBid() {
        return Bid;
    }

    public void setBid(Integer bid) {
        Bid = bid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
