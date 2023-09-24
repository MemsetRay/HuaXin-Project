package com.informationplatform.backend.mapper.impl;

import com.informationplatform.backend.mapper.CityMapper;
import com.informationplatform.backend.mapper.utils.JDBC;
import com.informationplatform.backend.pojo.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityMapperImpl implements CityMapper {
    private static final JDBC jdbc = new JDBC();
    @Override
    public List<City> SelectAll() {
        Connection connection= jdbc.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<City> list=new ArrayList<>();
        try {
            ps=connection.prepareStatement("SELECT * FROM CITY");
            rs=ps.executeQuery();
            while (rs.next())
            {
                City city=new City();
               city.setCityid(rs.getInt(1));
               city.setCityname(rs.getString(2));
               city.setIs_deleted(rs.getInt(3));
               list.add(city);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            jdbc.closeResult(rs);
            jdbc.closeStatement(ps);
            jdbc.closeConnection(connection);
        }
        return list;
    }

    @Override
    public City SelectById(int cityid) {
        Connection connection= jdbc.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        City city=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM CITY WHERE CITYID=?");
            ps.setInt(1,cityid);
            rs=ps.executeQuery();
            if (rs.next())
            {
                city=new City();
                city.setCityid(rs.getInt(1));
                city.setCityname(rs.getString(2));
                city.setIs_deleted(rs.getInt(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            jdbc.closeResult(rs);
            jdbc.closeStatement(ps);
            jdbc.closeConnection(connection);
        }
        return city;
    }

    @Override
    public int Update(City city) {
        Connection connection= jdbc.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try {
            ps=connection.prepareStatement("UPDATE CITY SET CITYNAME=? WHERE CITYID=?");
            ps.setString(1,city.getCityname());
            ps.setInt(2,city.getCityid());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            jdbc.closeResult(rs);
            jdbc.closeStatement(ps);
            jdbc.closeConnection(connection);
        }
        return result;
    }

    @Override
    public int Insert(City city) {
        Connection connection= jdbc.getConnection();
        PreparedStatement ps=null;
        int result=0;
        try {
            ps=connection.prepareStatement("INSERT INTO CITY (CITYNAME) VALUES (?)");
            ps.setString(1,city.getCityname());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            jdbc.closeStatement(ps);
            jdbc.closeConnection(connection);
        }
        return result;
    }

    @Override
    public int Delete(City city) {
        Connection connection=jdbc.getConnection();
        PreparedStatement ps=null;
        int result=0;
        try {
            ps=connection.prepareStatement("UPDATE CITY SET IS_DELETED=? WHERE CITYID=?");
            ps.setInt(1,city.getIs_deleted());
            ps.setInt(2,city.getCityid());
            result=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            jdbc.closeStatement(ps);
            jdbc.closeConnection(connection);
        }
        return result;
    }
}
