package com.informationplatform.backend.mapper.impl;

import com.informationplatform.backend.mapper.ScktMapper;
import com.informationplatform.backend.mapper.utils.JDBC;
import com.informationplatform.backend.pojo.Sckt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScktMapperImpl extends JDBC implements ScktMapper {
    @Override
    public List<Sckt> SelectAll() {
        Connection connection=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Sckt> list=new ArrayList<>();
        try {
            ps=connection.prepareStatement("SELECT * FROM SCKT");
            rs=ps.executeQuery();
            while (rs.next())
            {
                Sckt sckt=new Sckt();
                sckt.setId(rs.getInt(1));
                sckt.setSobject(rs.getString(2));
                sckt.setDemand1(rs.getString(3));
                sckt.setInvestment(rs.getString(4));
                sckt.setPlan(rs.getString(5));
                sckt.setFeedback(rs.getString(6));
                sckt.setTheway(rs.getString(7));
                sckt.setSummarize(rs.getString(8));
                sckt.setIs_deleted(rs.getInt(9));
                list.add(sckt);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            closeConnection(connection);
            closeResult(rs);
            closeStatement(ps);
        }
        return list;
    }

    @Override
    public Sckt SelectById(int id) {
        Connection connection=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Sckt sckt=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM SCKT WHERE ID=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
            if (rs.next())
            {
                sckt=new Sckt();
                sckt.setId(rs.getInt(1));
                sckt.setSobject(rs.getString(2));
                sckt.setDemand1(rs.getString(3));
                sckt.setInvestment(rs.getString(4));
                sckt.setPlan(rs.getString(5));
                sckt.setFeedback(rs.getString(6));
                sckt.setTheway(rs.getString(7));
                sckt.setSummarize(rs.getString(8));
                sckt.setIs_deleted(rs.getInt(9));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            closeStatement(ps);
            closeResult(rs);
            closeConnection(connection);
        }
        return sckt;
    }

    @Override
    public int Update(Sckt sckt) {
        Connection connection=getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try {
            ps=connection.prepareStatement("UPDATE SCKT SET SOBJECT=? WHERE ID=?");
            ps.setString(1,sckt.getSobject());
            ps.setInt(2,sckt.getId());
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
    public int Insert(Sckt sckt) {
        Connection connection=getConnection();
        PreparedStatement ps=null;
        int result=0;
        try {
            ps=connection.prepareStatement("INSERT INTO SCKT (SOBJECT) VALUES (?)");
            ps.setString(1,sckt.getSobject());
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
    public int Delete(Sckt sckt) {
        Connection connection=getConnection();
        PreparedStatement ps=null;
        int result=0;
        try {
            ps=connection.prepareStatement("UPDATE SCKT SET IS_DELETED=? WHERE ID=?");
            ps.setInt(1,sckt.getIs_deleted());
            ps.setInt(2,sckt.getId());
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

