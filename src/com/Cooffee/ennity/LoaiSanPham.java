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
public class LoaiSanPham {

    private String maLoai;
    private String tenLoaiSP;
    private String kichThuot;

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public String getKichThuot() {
        return kichThuot;
    }

    public void setKichThuot(String kichThuot) {
        this.kichThuot = kichThuot;
    }

    public LoaiSanPham(String kichThuot) {
        this.kichThuot = kichThuot;
    }

    public LoaiSanPham() {
    }
    
}
