package com.chungdoan.mob2041.models;

public class Sach {
    private int masach;
    private String tensach;
    private String tacgia;
    private int giaban;
    private int maloai;

    public Sach(int masach, String tensach, String tacgia, int giaban, int maloai) {
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.giaban = giaban;
        this.maloai = maloai;
    }
    public Sach (){

    }

    public int getMasach() {
        return masach;
    }

    public void setMasach(int masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }
}
