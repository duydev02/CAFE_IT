/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Cooffee.ennity;

/**
 *
 * @author LeBaoDang
 */
public class SanPham {

    private String ID;
    private String tenSp;
    private String maLoai;
    private Double gia;
    private String kichThuot;

    public String getKichThuot() {
        return kichThuot;
    }

    public void setKichThuot(String kichThuot) {
        this.kichThuot = kichThuot;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

}
