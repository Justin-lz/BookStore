package org.bsm.bsm.entity;

//存储一本图书的基本信息，等待修改
public class Book {
    private Integer Bid;
    private  String Bname;
    private String Bauthor;
    private String Bpress;
    private Integer Bcount;
    private String Bresume;
    private Integer Tid;

    public Integer getBid() {
        return Bid;
    }

    public void setBid(Integer bid) {
        Bid = bid;
    }

    public String getBname() {
        return Bname;
    }

    public void setBname(String bname) {
        Bname = bname;
    }

    public String getBauthor() {
        return Bauthor;
    }

    public void setBauthor(String bauthor) {
        Bauthor = bauthor;
    }

    public String getBpress() {
        return Bpress;
    }

    public void setBpress(String bpress) {
        Bpress = bpress;
    }

    public Integer getBcount() {
        return Bcount;
    }

    public void setBcount(Integer bcount) {
        Bcount = bcount;
    }

    public String getBresume() {
        return Bresume;
    }

    public void setBresume(String bresume) {
        Bresume = bresume;
    }

    public Integer getTid() {
        return Tid;
    }

    public void setTid(Integer tid) {
        Tid = tid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Bid=" + Bid +
                ", Bname='" + Bname + '\'' +
                ", Bauthor='" + Bauthor + '\'' +
                ", Bpress='" + Bpress + '\'' +
                ", Bcount=" + Bcount +
                ", Bresume='" + Bresume + '\'' +
                ", Tid=" + Tid +
                '}';
    }
}
