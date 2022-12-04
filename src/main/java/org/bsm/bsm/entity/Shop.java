package org.bsm.bsm.entity;

public class Shop{

    private Integer Bid;
    private Integer Uid;
    private Integer Scount;

    public Integer getBid(){
        return this.Bid;
    }

    public Integer getUid(){
        return this.Uid;
    }

    public Integer getScount(){
        return this.Scount;
    }

    public void setBid(Integer Bid){
        this.Bid = Bid;
    }

    public void setUid(Integer Uid){
        this.Uid = Uid;
    }

    public void setScount(Integer Scount){
        this.Scount = Scount;
    }

}