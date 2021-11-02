/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Cooffee.Dao;

import com.Cooffee.ennity.SanPham;
import com.Cooffee.ennity.ThongKe;
import com.cooffe.uitls.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeBaoDang
 */
public class ThongKeDAO extends CooffeeDAO<ThongKe, String>{

    @Override
    public void insert(ThongKe entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ThongKe entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ThongKe selectById(String id) {
        String sql = "SELECT * FROM Order where IDOrder = ?";
        List<ThongKe> list = this.selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<ThongKe> selectAll() {
        String sql = "select * from OrderDetails join [Order] on OrderDetails.IDOrder=[Order].IDOrder \n" +
        "join Product on OrderDetails.IDProduct=Product.IDProduct Order by OrderDetails.IDOrder DESC";
        return this.selectBySql(sql);
    }

    @Override
    protected List<ThongKe> selectBySql(String sql, Object... args) {
        List<ThongKe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    ThongKe entity = new ThongKe();
                    entity.setMaDatHang(rs.getString("IDOrder"));
                    entity.setTenSP(rs.getString("ProductName"));
                    entity.setGiaBan(rs.getInt("Price"));
                    entity.setMaLoai(rs.getString("IDType"));
                    entity.setQuantity(rs.getInt("Quantity"));
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
