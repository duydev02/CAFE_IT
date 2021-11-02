/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Cooffee.Dao;

import com.Cooffee.ennity.HoaDon;
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
public class HoaDonDAO extends CooffeeDAO<HoaDon, String>{

    @Override
    public void insert(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HoaDon selectById(String id) {
        String sql = "SELECT * FROM Order where IDOrder=?";
        List<HoaDon> list = this.selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<HoaDon> selectAll() {
        String sql = "select * from OrderDetails join [Order] on OrderDetails.IDOrder=[Order].IDOrder Order by OrderDetails.IDOrder DESC";
        return this.selectBySql(sql);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    HoaDon entity = new HoaDon();
                    entity.setMaDonHang(rs.getString("IDOrder"));
                    entity.setMaSanPham(rs.getString("IDProduct"));
                    entity.setMaKhachHang(rs.getString("CusName"));
                    entity.setSoLuong(rs.getInt("Quantity"));
                    entity.setCtkm(rs.getString("NamePromo"));
                    entity.setThoiGian(rs.getString("TimeOrder"));
                    entity.setNgay(rs.getString("DateOrder"));
                    entity.setMaNV(rs.getString("UsernameEmp"));
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
