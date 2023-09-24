package com.informationplatform.backend.mapper.impl;

import com.informationplatform.backend.mapper.UserMapper;
import com.informationplatform.backend.mapper.utils.JDBC;
import com.informationplatform.backend.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMapperImpl implements UserMapper {
    private final JDBC jdbc = new JDBC();
    @Override
    public User getByUsername(String username) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement("select * from user where name = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setEnterprise(resultSet.getString("enterprise"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setEmail(resultSet.getString("email"));
                user.setBase(resultSet.getString("base"));
                user.setIndustry(resultSet.getString("industry"));
                user.setEnterprisePhoto(resultSet.getString("enterprise_photo"));
                user.setIsDeleted(resultSet.getInt("is_deleted"));
                user.setBaseId(resultSet.getInt("base_id"));
                user.setIndustryId(resultSet.getInt("industry_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(resultSet);
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
        return user;
    }

    @Override
    public List<User> getByBaseId(int baseId) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from user where base_id = ?");
            preparedStatement.setInt(1, baseId);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setEnterprise(resultSet.getString("enterprise"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setEmail(resultSet.getString("email"));
                user.setBase(resultSet.getString("base"));
                user.setIndustry(resultSet.getString("industry"));
                user.setEnterprisePhoto(resultSet.getString("enterprise_photo"));
                user.setIsDeleted(resultSet.getInt("is_deleted"));
                user.setBaseId(resultSet.getInt("base_id"));
                user.setIndustryId(resultSet.getInt("industry_id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(resultSet);
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }

        return userList;
    }

    @Override
    public List<User> getByIndustryId(int industryId) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from user where industry_id = ?");
            preparedStatement.setInt(1, industryId);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setEnterprise(resultSet.getString("enterprise"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setEmail(resultSet.getString("email"));
                user.setBase(resultSet.getString("base"));
                user.setIndustry(resultSet.getString("industry"));
                user.setEnterprisePhoto(resultSet.getString("enterprise_photo"));
                user.setIsDeleted(resultSet.getInt("is_deleted"));
                user.setBaseId(resultSet.getInt("base_id"));
                user.setIndustryId(resultSet.getInt("industry_id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(resultSet);
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }

        return userList;
    }

    @Override
    public List<User> getAllUser() {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from user");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                user.setEnterprise(resultSet.getString("enterprise"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setEmail(resultSet.getString("email"));
                user.setBase(resultSet.getString("base"));
                user.setIndustry(resultSet.getString("industry"));
                user.setEnterprisePhoto(resultSet.getString("enterprise_photo"));
                user.setIsDeleted(resultSet.getInt("is_deleted"));
                user.setBaseId(resultSet.getInt("base_id"));
                user.setIndustryId(resultSet.getInt("industry_id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(resultSet);
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }

        return userList;
    }

    @Override
    public void insert(User user) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into user (name,password,enterprise,telephone,email,base,industry,enterprise_photo,base_id,industry_id) values (?,?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEnterprise());
            preparedStatement.setString(4, user.getTelephone());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getBase());
            preparedStatement.setString(7, user.getIndustry());
            preparedStatement.setString(8, user.getEnterprisePhoto());
            preparedStatement.setInt(9,user.getBaseId());
            preparedStatement.setInt(10, user.getIndustryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
    }//城市/基地/企业/产品/行业    政策法规/咨询动态/公共服务平台/市场开拓/

    @Override
    public void change(User user) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update user set name=?,password=?,enterprise=?,telephone=?,email=?,base=?,industry=?,enterprise_photo=?,base_id=?,industry_id=? where id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEnterprise());
            preparedStatement.setString(4, user.getTelephone());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getBase());
            preparedStatement.setString(7, user.getIndustry());
            preparedStatement.setString(8, user.getEnterprisePhoto());
            preparedStatement.setInt(9,user.getBaseId());
            preparedStatement.setInt(10, user.getIndustryId());
            preparedStatement.setInt(11, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
    }

    @Override
    public void delete(String username) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update user set is_deleted = 1 where name = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
    }
}
