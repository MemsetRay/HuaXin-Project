package com.informationplatform.backend.mapper.impl;

import com.informationplatform.backend.mapper.BaseMapper;
import com.informationplatform.backend.mapper.utils.JDBC;
import com.informationplatform.backend.pojo.Base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseMapperImpl implements BaseMapper {
    private final JDBC jdbc = new JDBC();

    @Override
    public Base getByBaseId(int baseId) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Base base = new Base();
        try {
            preparedStatement = connection.prepareStatement("select * from base where id = ?");
            preparedStatement.setInt(1, baseId);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                base.setId(resultSet.getInt("id"));
                base.setName(resultSet.getString("name"));
                base.setIntroduction(resultSet.getString("introduction"));
                base.setLocation(resultSet.getString("location"));
                base.setIs_deleted(resultSet.getInt("is_deleted"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(resultSet);
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
        return base;
    }

    @Override
    public List<Base> getByCityId(int cityId) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Base> baseList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from base where city_id = ?");
            preparedStatement.setInt(1, cityId);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Base base = new Base();
                base.setId(resultSet.getInt("id"));
                base.setName(resultSet.getString("name"));
                base.setIntroduction(resultSet.getString("introduction"));
                base.setLocation(resultSet.getString("location"));
                base.setIs_deleted(resultSet.getInt("is_deleted"));
                baseList.add(base);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(resultSet);
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
        return baseList;
    }

    @Override
    public List<Base> getAllBase() {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Base> baseList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from base");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Base base = new Base();
                base.setId(resultSet.getInt("id"));
                base.setName(resultSet.getString("name"));
                base.setIntroduction(resultSet.getString("introduction"));
                base.setLocation(resultSet.getString("location"));
                base.setIs_deleted(resultSet.getInt("is_deleted"));
                baseList.add(base);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(resultSet);
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
        return baseList;
    }

    @Override
    public void insert(Base base) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into base (name,introduction,location,city_id) values (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, base.getName());
            preparedStatement.setString(2, base.getIntroduction());
            preparedStatement.setString(3, base.getLocation());
            preparedStatement.setInt(4, base.getCityId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
    }

    @Override
    public void change(Base base) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update base set name=?,introduction=?,location=?,city_id=? where id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, base.getName());
            preparedStatement.setString(2, base.getIntroduction());
            preparedStatement.setString(3, base.getLocation());
            preparedStatement.setInt(4, base.getCityId());
            preparedStatement.setInt(5, base.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
    }

    @Override
    public void delete(int baseId) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update base set is_deleted = 1 where id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, baseId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
    }
}
