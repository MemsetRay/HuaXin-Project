package com.informationplatform.backend.mapper.impl;

import com.informationplatform.backend.mapper.NoticeMapper;
import com.informationplatform.backend.mapper.utils.JDBC;
import com.informationplatform.backend.pojo.Notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoticeMapperImpl implements NoticeMapper {
    private static final JDBC jdbc = new JDBC();
    @Override
    public List<Notice> SelectAll() {
        Connection connection= jdbc.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Notice> list=new ArrayList<>();
        try {
            ps=connection.prepareStatement("SELECT * FROM NOTICE");
            rs=ps.executeQuery();
            while (rs.next())
            {
                Notice notice=new Notice();
                notice.setId(rs.getInt(1));
                notice.setTitle(rs.getString(2));
                notice.setDate(rs.getString(3));
                notice.setContent(rs.getString(4));
                notice.setIs_deleted(rs.getInt(5));
                list.add(notice);
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
    public Notice SelectById(int id) {
        Connection connection= jdbc.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Notice notice1=null;
        try {
            ps=connection.prepareStatement("SELECT * FROM NOTICE WHERE ID=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
           if (rs.next())
            {
                notice1=new Notice();
                notice1.setId(rs.getInt(1));
                notice1.setTitle(rs.getString(2));
                notice1.setDate(rs.getString(3));
                notice1.setContent(rs.getString(4));
                notice1.setIs_deleted(rs.getInt(5));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            jdbc.closeResult(rs);
            jdbc.closeStatement(ps);
            jdbc.closeConnection(connection);
        }
        return notice1;
    }

    @Override
    public int Update(Notice notice) {
        Connection connection= jdbc.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try {
            ps=connection.prepareStatement("UPDATE NOTICE SET TITLE=?,DATE=?,CONTENT=? WHERE ID=?");

            ps.setString(1,notice.getTitle());
            ps.setString(2,notice.getDate());
            ps.setString(3,notice.getContent());
            ps.setInt(4,notice.getId());
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
    public int Insert(Notice notice) {
        Connection connection=null;
        PreparedStatement ps=null;
        int result=0;
        try {
            connection= jdbc.getConnection();
            ps=connection.prepareStatement("INSERT INTO NOTICE (TITLE,DATE,CONTENT) VALUES (?,?,?)");
            //System.out.println(notice.getTitle()+notice.getDate()+notice.getContent());
            ps.setString(1,notice.getTitle());
            ps.setString(2,notice.getDate());
            ps.setString(3,notice.getContent());
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
    public int Delete(Notice notice) {
        Connection connection= jdbc.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int result=0;
        try {
            ps=connection.prepareStatement("UPDATE NOTICE SET IS_DELETED=? WHERE ID=?");
            ps.setInt(1,notice.getIs_deleted());
            ps.setInt(2,notice.getId());
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
}
