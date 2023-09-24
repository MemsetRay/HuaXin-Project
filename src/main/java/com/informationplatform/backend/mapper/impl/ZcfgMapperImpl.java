package com.informationplatform.backend.mapper.impl;

import com.informationplatform.backend.mapper.ZcfgMapper;
import com.informationplatform.backend.mapper.utils.JDBC;
import com.informationplatform.backend.pojo.Zcfg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ZcfgMapperImpl extends JDBC implements ZcfgMapper {
    @Override
    public List<Zcfg> SelectAll() {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Zcfg> list = new ArrayList<>();
        try {
            ps = connection.prepareStatement("SELECT * FROM ZCFG");
            rs = ps.executeQuery();
            while (rs.next()) {
                Zcfg zcfg = new Zcfg();
                zcfg.setId(rs.getInt(1));
                zcfg.setTopic(rs.getString(2));
                zcfg.setLianjie(rs.getString(4));
                zcfg.setFujianlianjie(rs.getString(5));
                zcfg.setIs_deleted(rs.getInt(6));
                list.add(zcfg);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(connection);
            closeResult(rs);
            closeStatement(ps);
        }
        return list;
    }

    @Override
    public Zcfg SelectById(int id) {
        Connection connection=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Zcfg zcfg=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM ZCFG WHERE ID=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if (rs.next())
            {
                zcfg.setId(rs.getInt(1));
                zcfg.setTopic(rs.getString(2));
                zcfg.setLianjie(rs.getString(3));
                zcfg.setFujianlianjie(rs.getString(4));
                zcfg.setIs_deleted(rs.getInt(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            closeStatement(ps);
            closeResult(rs);
            closeConnection(connection);
        }
        return zcfg;
    }

    @Override
    public int Update(Zcfg zcfg) {
        Connection connection=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try {
            ps=connection.prepareStatement("UPDATE ZCFG SET TOPIC=? WHERE ID=?");
            ps.setString(1,zcfg.getTopic());
            ps.setInt(2,zcfg.getId());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            closeConnection(connection);
            closeResult(rs);
            closeStatement(ps);
        }
        return result;
    }

    @Override
    public int Insert(Zcfg zcfg) {
        Connection connection=getConnection();
        PreparedStatement ps=null;
        int result=0;
        try {
            ps=connection.prepareStatement("INSERT INTO ZCFG (TOPIC) VALUES (?)");
            ps.setString(1,zcfg.getTopic());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            closeConnection(connection);
            closeStatement(ps);
        }
        return result;
    }

    @Override
    public int Delete(Zcfg zcfg) {
        Connection connection=getConnection();
        PreparedStatement ps=null;
        int result=0;
        try {
            ps=connection.prepareStatement("UPDATE ZCFG SET IS_DELETED=? WHERE ID=?");
            ps.setInt(1,zcfg.getIs_deleted());
            ps.setInt(2,zcfg.getId());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            closeConnection(connection);
            closeStatement(ps);
        }
        return result;
    }
}
