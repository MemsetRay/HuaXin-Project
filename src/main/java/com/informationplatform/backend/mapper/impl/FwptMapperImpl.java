package com.informationplatform.backend.mapper.impl;

import com.informationplatform.backend.mapper.FwptMapper;
import com.informationplatform.backend.pojo.Fwpt;
import com.informationplatform.backend.mapper.utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FwptMapperImpl extends JDBC implements FwptMapper {
    @Override
    public List<Fwpt> SelectAll() {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Fwpt> list = new ArrayList<>();
        try {
            ps = connection.prepareStatement("SELECT * FROM FWPT");
            rs = ps.executeQuery();
            while (rs.next()) {
                Fwpt fwpt = new Fwpt();
                fwpt.setId(rs.getInt(1));
                fwpt.setInformation(rs.getString(2));
                fwpt.setQuestion(rs.getString(3));
                fwpt.setIdea(rs.getString(4));
                fwpt.setIs_deleted(rs.getInt(5));
                list.add(fwpt);
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
    public Fwpt SelectById(int id) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Fwpt fwpt = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM CITY WHERE ID=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                fwpt = new Fwpt();
                fwpt.setId(rs.getInt(1));
                fwpt.setInformation(rs.getString(2));
                fwpt.setQuestion(rs.getString(3));
                fwpt.setIdea(rs.getString(4));
                fwpt.setIs_deleted(rs.getInt(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeStatement(ps);
            closeResult(rs);
            closeConnection(connection);
        }
        return fwpt;
    }

    @Override
    public int Update(Fwpt fwpt) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        try {
            ps = connection.prepareStatement("UPDATE FWPT SET INFORMATION=? WHERE ID=?");
            ps.setString(1, fwpt.getInformation());
            ps.setInt(2, fwpt.getId());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(connection);
            closeResult(rs);
            closeStatement(ps);
        }
        return result;
    }

    @Override
    public int Insert(Fwpt fwpt) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        int result = 0;
        try {
            ps = connection.prepareStatement("INSERT INTO FWPT (INFORMATION) VALUES (?)");
            ps.setString(1, fwpt.getInformation());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(connection);
            closeStatement(ps);
        }
        return result;
    }

    @Override
    public int Delete(Fwpt fwpt) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        int result = 0;
        try {
            ps = connection.prepareStatement("UPDATE FWPT SET IS_DELETED=? WHERE ID=?");
            ps.setInt(1, fwpt.getIs_deleted());
            ps.setInt(2, fwpt.getId());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnection(connection);
            closeStatement(ps);
        }
        return result;
    }
}

