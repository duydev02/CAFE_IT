/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Cooffee.Dao;

import com.Cooffee.ennity.NhanVien;
import com.cooffe.uitls.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeBaoDang
 */
public class NhanVienDAO extends CooffeeDAO<NhanVien, String> {

    @Override
    public void insert(NhanVien entity) {
        String sql="INSERT INTO Employee (UsernameEmp, Password,NameEmp, vaitro, Gender,Phone,Email,Address,Hinh) VALUES (?, ?, ?, ?,?,?,?,?,?)";
        XJdbc.update(sql, 
                entity.getMaNV(),
                entity.getMatKhau(),
                entity.getTenNV(),
                entity.isVaiTro(),
                entity.isGioiTinh(),
                entity.getsDT(),
                entity.getEmail(),
                entity.getDiaChi(),
                entity.getHinh());
    }

    @Override
    public void update(NhanVien entity) {
        String sql="UPDATE Employee SET Password=?, NameEmp=?, VaiTro=?, Gender=?,Phone=?,Email=?,Address=?,Hinh=? WHERE UsernameEmp=?";
        XJdbc.update(sql, 
                entity.getMatKhau(), 
                entity.getTenNV(), 
                entity.isVaiTro(),
                entity.isGioiTinh(),
                entity.getsDT(),
                entity.getEmail(),
                entity.getDiaChi(),
                entity.getHinh(),
                entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        String sql="DELETE FROM Employee WHERE UsernameEmp=?";
        XJdbc.update(sql, id);
    }

    @Override
    public NhanVien selectById(String id) {
        String sql = "SELECT * FROM Employee where UsernameEmp = ?";
        List<NhanVien> list = this.selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql = "SELECT * FROM Employee";
        return this.selectBySql(sql);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    NhanVien entity = new NhanVien();
                    entity.setMaNV(rs.getString("UsernameEmp"));
                    entity.setMatKhau(rs.getString("Password"));
                    entity.setTenNV(rs.getString("NameEmp"));
                    entity.setVaiTro(rs.getBoolean("VaiTro"));
                    entity.setGioiTinh(rs.getBoolean("Gender"));
                    entity.setsDT(rs.getString("Phone"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setDiaChi(rs.getString("Address"));
                    entity.setHinh(rs.getString("Hinh"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }

}
