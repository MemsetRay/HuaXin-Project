package com.informationplatform.backend.mapper.impl;
import com.informationplatform.backend.mapper.DymMapper;
import com.informationplatform.backend.mapper.utils.JDBC;
import com.informationplatform.backend.pojo.Dym;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 对DymEntity这个数据库的增删改查操作，
 * 这个类实现了Dymdao的接口，
 * 并且继承Dbconnection类以便快速的获取con句柄；
 * 对数据库的连接以及关闭
 */
public class DymMapperImpl implements DymMapper {
    private final JDBC jdbc = new JDBC();
    @Override
    public void selectAll() {  //查询表中所有数据
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = jdbc.getConnection();
        String sql = "select * from Dynamic";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("is_deleted") == 0) {
                    System.out.println("id:" + rs.getInt("id"));
                    System.out.println("title:" + rs.getString("title"));
                    System.out.println("content:" + rs.getString("text"));
                    System.out.println("time:" + rs.getTimestamp("time"));
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
    public List<Dym> selectTolist() { //对表中数据一行看成一个对象，把数据添加到集合中，返回这个集合
        Connection con = null;
        List<Dym> lst = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = jdbc.getConnection();
        String sql = "select * from Dynamic";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("is_deleted") == 0) {

                    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String newtime = s.format(rs.getTimestamp("time"));
                    lst.add(new Dym(rs.getString("title"), rs.getString("text"), newtime));
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
    public Dym select(Dym dym) { //根据条件进行查询，返回一个对象
        Connection con = null;
        con = jdbc.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Dynamic where id=?";


        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dym.getId());
            rs = ps.executeQuery();
            if (rs.next()) {

                if (rs.getInt("is_deleted") == 0) {
                    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String newtime = s.format(rs.getTimestamp("time"));

                    return new Dym(rs.getString("title"), rs.getString("text"), newtime);
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
    public int insert(Dym dym) { //插入数据
        Connection con = jdbc.getConnection();
        PreparedStatement ps = null;
        int i = 0;
        try {
            String sql = "INSERT INTO dynamic (title,text) VALUES (?,?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, dym.getTitle());
            ps.setString(2, dym.getContent());
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
    public int delete(Dym dym) {
        Dym d = select(dym);
        Connection con = jdbc.getConnection();
        PreparedStatement ps = null;
        int i = 0;
        String sql = "update Dynamic set is_deleted=1 where id=?";
        try {

            if (d == null) {
                System.out.println("表中无此人,删除失败");

                return -1;
            }//表中无此人，或者已删除
            ps = con.prepareStatement(sql);
            ps.setInt(1, dym.getId());
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
    public int update(Dym dym) {
        Connection con = jdbc.getConnection();
        PreparedStatement ps = null;
        int i = 0;
        String sql = "update Dynamic set title=?,text=?,time=? where id=?";
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Dym dd = select(dym);//查询表中是否有该id，如果没有，则不执行下面语句
        if (dd == null) {
            System.out.println("表中无此人，更新失败");
            return -1;
        }
        try {
            ps = con.prepareStatement(sql);
            Date d = new Date();
            ps.setString(1, dym.getTitle());
            ps.setString(2, dym.getContent());
            ps.setString(3, s.format(d));
            ps.setInt(4, dym.getId());

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
