package com.informationplatform.backend.mapper.impl;

import com.informationplatform.backend.mapper.ProductMapper;
import com.informationplatform.backend.mapper.utils.JDBC;
import com.informationplatform.backend.pojo.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductMapperImpl implements ProductMapper {
    private final JDBC jdbc = new JDBC();

    @Override
    public Product getByProductId(int productId) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = new Product();
        try {
            preparedStatement = connection.prepareStatement("select * from product where id = ?");
            preparedStatement.setInt(1, productId);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setUserId(resultSet.getInt("user_id"));
                product.setName(resultSet.getString("name"));
                product.setModel(resultSet.getString("model"));
                product.setIndustry(resultSet.getString("industry"));
                product.setIntroduction(resultSet.getString("introduction"));
                product.setPhoto(resultSet.getString("photo"));
                product.setBrand(resultSet.getString("brand"));
                product.setProducer(resultSet.getString("producer"));
                product.setIndustryId(resultSet.getInt("industry_id"));
                product.setIsDeleted(resultSet.getInt("is_deleted"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(resultSet);
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
        return product;
    }

    @Override
    public List<Product> getByUserId(int userId) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from product where user_id = ?");
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setUserId(resultSet.getInt("user_id"));
                product.setName(resultSet.getString("name"));
                product.setModel(resultSet.getString("model"));
                product.setIndustry(resultSet.getString("industry"));
                product.setIntroduction(resultSet.getString("introduction"));
                product.setPhoto(resultSet.getString("photo"));
                product.setBrand(resultSet.getString("brand"));
                product.setProducer(resultSet.getString("producer"));
                product.setIndustryId(resultSet.getInt("industry_id"));
                product.setIsDeleted(resultSet.getInt("is_deleted"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(resultSet);
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
        return productList;
    }

    @Override
    public List<Product> getByIndustryId(int industryId) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from product where industry_id = ?");
            preparedStatement.setInt(1, industryId);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setUserId(resultSet.getInt("user_id"));
                product.setName(resultSet.getString("name"));
                product.setModel(resultSet.getString("model"));
                product.setIndustry(resultSet.getString("industry"));
                product.setIntroduction(resultSet.getString("introduction"));
                product.setPhoto(resultSet.getString("photo"));
                product.setBrand(resultSet.getString("brand"));
                product.setProducer(resultSet.getString("producer"));
                product.setIndustryId(resultSet.getInt("industry_id"));
                product.setIsDeleted(resultSet.getInt("is_deleted"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(resultSet);
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
        return productList;
    }

    @Override
    public List<Product> getAllProduct() {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from product");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setUserId(resultSet.getInt("user_id"));
                product.setName(resultSet.getString("name"));
                product.setModel(resultSet.getString("model"));
                product.setIndustry(resultSet.getString("industry"));
                product.setIntroduction(resultSet.getString("introduction"));
                product.setPhoto(resultSet.getString("photo"));
                product.setBrand(resultSet.getString("brand"));
                product.setProducer(resultSet.getString("producer"));
                product.setIndustryId(resultSet.getInt("industry_id"));
                product.setIsDeleted(resultSet.getInt("is_deleted"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeResult(resultSet);
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
        return productList;
    }

    @Override
    public void insert(Product product) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into product (user_id,name,model,industry,introduction,photo,brand,producer,industry_id) values (?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getUserId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getModel());
            preparedStatement.setString(4, product.getIndustry());
            preparedStatement.setString(5, product.getIntroduction());
            preparedStatement.setString(6, product.getPhoto());
            preparedStatement.setString(7, product.getBrand());
            preparedStatement.setString(8, product.getProducer());
            preparedStatement.setInt(9, product.getIndustryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
    }

    @Override
    public void change(Product product) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update product set user_id=?,name=?,model=?,industry=?,introduction=?,photo=?,brand=?,producer=?,industry_id=? where id=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getUserId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getModel());
            preparedStatement.setString(4, product.getIndustry());
            preparedStatement.setString(5, product.getIntroduction());
            preparedStatement.setString(6, product.getPhoto());
            preparedStatement.setString(7, product.getBrand());
            preparedStatement.setString(8, product.getProducer());
            preparedStatement.setInt(9, product.getIndustryId());
            preparedStatement.setInt(10, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
    }

    @Override
    public void delete(int productId) {
        Connection connection = jdbc.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "update product set is_deleted = 1 where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbc.closeStatement(preparedStatement);
            jdbc.closeConnection(connection);
        }
    }
}
