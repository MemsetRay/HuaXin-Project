package com.informationplatform.backend.mapper.impl;
import com.informationplatform.backend.mapper.IndustyMapper;
import com.informationplatform.backend.mapper.utils.JDBC;
import com.informationplatform.backend.pojo.Industy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * 对industyEntity这个数据库的增删改查操作，
 * 这个类实现了industydao的接口，
 * 并且继承Dbconnection类以便快速的获取con句柄；
 * 对数据库的连接以及关闭
 */
public class IndustyMapperImpl implements IndustyMapper {
    private static final JDBC jdbc = new JDBC();
    @Override
    public void selectAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = jdbc.getConnection();
        String sql = "select * from industy";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("is_deleted") == 0) {
                    System.out.println("id:" + rs.getInt("id"));
                    System.out.println("name:" + rs.getString("name"));
                    System.out.println("e_id:" + rs.getInt("e_id"));
                    System.out.println("out_id:" + rs.getInt("out_id"));
                    System.out.println("product_id:" + rs.getInt("out_id"));

                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(rs);
            jdbc.closeStatement(ps);
            jdbc.closeConnection(con);
        }

    }

    @Override
    public List<Industy> selectTolist() {
        Connection con = null;
        List<Industy> lst = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = jdbc.getConnection();
        String sql = "select * from industy";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("is_deleted") == 0) {


                    lst.add(new Industy(rs.getString("name"), rs.getInt("e_id"), rs.getInt("out_id"), rs.getInt("product_id")));
                }
            }
            return lst;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(rs);
            jdbc.closeStatement(ps);
            jdbc.closeConnection(con);
        }

    }

    @Override
    public Industy select(Industy in) {
        Connection con = null;
        con = jdbc.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Industy where id=?";


        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, in.getId());
            rs = ps.executeQuery();
            if(rs.next()) {
                if (rs.getInt("is_deleted") == 0) {


                    return new Industy(rs.getString("name"), rs.getInt("e_id"), rs.getInt("out_id"), rs.getInt("product_id"));


                }
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(rs);
            jdbc.closeStatement(ps);
            jdbc.closeConnection(con);
        }

    }

    @Override
    public int insert(Industy in) {
        Connection con = jdbc.getConnection();
        PreparedStatement ps = null;
        int i = 0;

        try {
            String sql = "INSERT INTO industy (name,e_id,out_id,product_id) VALUES (?,?,?,?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, in.getName());
            ps.setInt(2, in.getEnterpriseId());
            ps.setInt(3, in.getOutputId());
            ps.setInt(4, in.getProductId());

            i = ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeStatement(ps);
            jdbc.closeConnection(con);
        }
        return i;
    }

    @Override
    public int delete(Industy in) {
        Industy d = select(in);
        Connection con = jdbc.getConnection();
        PreparedStatement ps = null;
        int i = 0;
        String sql = "update Industy set is_deleted=1 where id=?";
        try {

            if (d == null) {
                System.out.println("表中无此数据，删除失败");
                return -1;
            }//表中无此人，或者已删除
            ps = con.prepareStatement(sql);
            ps.setInt(1, in.getId());
            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeStatement(ps);
            jdbc.closeConnection(con);
        }
        return i;

    }

    @Override
    public int update(Industy in) {
        Connection con = jdbc.getConnection();
        PreparedStatement ps = null;
        String sql = "update industy set name=?,e_id=?,out_id=?,product_id=? where id=?";
        int i = 0;
        Industy dd = select(in);
        if (dd == null) {
            System.out.println("表中无此数据，更新失败");
            return -1;
        }
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, in.getName());
            ps.setInt(2, in.getEnterpriseId());
            ps.setInt(3, in.getOutputId());
            ps.setInt(4, in.getProductId());
            ps.setInt(5, in.getId());

            i = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeStatement(ps);
            jdbc.closeConnection(con);
        }
        return i;
    }

}