/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Cooffee.Dao;

import com.Cooffee.ennity.LoaiSanPham;
import com.cooffe.uitls.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LeBaoDang
 */
public class LoaiSanPhamDao extends CooffeeDAO<LoaiSanPham, String>{

    @Override
    public void insert(LoaiSanPham entity) {
        String sql="insert into Product values(?,?,?,?)";
        XJdbc.update(sql, 
            entity.getMaLoai(),
            entity.getTenLoaiSP(),
            entity.getKichThuot());           
    }

    @Override
    public void update(LoaiSanPham entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoaiSanPham selectById(String id) {
        String sql="SELECT * FROM ProductType WHERE IDType=?";
        List<LoaiSanPham> list = selectBySql(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<LoaiSanPham> selectAll() {
        String sql="SELECT * FROM ProductType";
        return selectBySql(sql);
    }

    @Override
    protected List<LoaiSanPham> selectBySql(String sql, Object... args) {
        List<LoaiSanPham> list=new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while(rs.next()){
                    LoaiSanPham entity=new LoaiSanPham();
                    entity.setMaLoai(rs.getString("IDType"));
                    entity.setTenLoaiSP(rs.getString("TypeName"));
                    entity.setKichThuot(rs.getString("Size"));
                    list.add(entity);
                }
            } 
            finally{
                rs.getStatement().getConnection().close();
            }
        } 
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    
}
