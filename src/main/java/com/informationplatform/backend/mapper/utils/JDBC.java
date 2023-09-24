package com.informationplatform.backend.mapper.utils;
import java.sql.*;

public class JDBC {
    public Connection getConnection () {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/informationplatform";
            String username = "root";
            String password = "liqingren";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void closeConnection (Connection connection) {
        try {
            if(connection != null) connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeStatement (PreparedStatement preparedStatement) {
        try {
            if(preparedStatement != null) preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeResult (ResultSet resultSet) {
        try {
            if(resultSet != null) resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
