package org.bsm.bsm.entity;

import java.util.Date;

public class Discount{
    private Integer Did;
    private Date Dstart;
    private Date Dend;
    private Integer Dcount;
    private Float Dprice;
    private Float Ddis;
    private Float Ddec;

    public Integer getDid() {
        return Did;
    }

    public void setDid(Integer did) {
        Did = did;
    }

    public Date getDStart() {
        return Dstart;
    }

    public void setDStart(Date Dstart) {
        this.Dstart = Dstart;
    }

    public Date getDEnd() {
        return Dend;
    }

    public void setDEnd(Date Dend) {
        this.Dend = Dend;
    }

    public Integer getDcount() {
        return Dcount;
    }

    public void setDcount(Integer dcount) {
        Dcount = dcount;
    }

    public Float getDprice() {
        return Dprice;
    }

    public void setDprice(Float dprice) {
        Dprice = dprice;
    }

    public Float getDdis() {
        return Ddis;
    }

    public void setDdis(Float ddis) {
        Ddis = ddis;
    }

    public Float getDdec() {
        return Ddec;
    }

    public void setDdec(Float ddec) {
        Ddec = ddec;
    }
}