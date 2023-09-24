package com.informationplatform.backend.test;


import com.informationplatform.backend.mapper.impl.NoticeMapperImpl;
import com.informationplatform.backend.pojo.Notice;

import java.util.List;

public class TestNotice {
    public static void main(String[] args) {
       TestNotice testNotic=new TestNotice();
       //testNotic.testSelectall();
        //testNotic.testSelectByid();
        //testNotic.testUpdate();
        //testNotic.testDelete();
        testNotic.testInsert();
    }
    public  void testSelectall()
    {
        NoticeMapperImpl noticeMapper= new NoticeMapperImpl();
        List<Notice> list=noticeMapper.SelectAll();
        for (Notice notice:list)
        {
            System.out.print(notice.getId()+"\t");
            System.out.print(notice.getTitle()+"\t");
            System.out.print(notice.getDate()+"\t");
            System.out.print(notice.getContent()+"\t");
            System.out.println(notice.getIs_deleted()+"\t");
        }
    }
    public  void testSelectByid()
    {
        NoticeMapperImpl noticeMapper= new NoticeMapperImpl();
        Notice notice = noticeMapper.SelectById(2);
        if(notice!=null)
        {
            System.out.print(notice.getId()+"\t");
            System.out.print(notice.getTitle()+"\t");
            System.out.print(notice.getDate()+"\t");
            System.out.print(notice.getContent()+"\t");
            System.out.println(notice.getIs_deleted()+"\t");
        }else {
            System.out.println("false");
        }
    }
    public  void testUpdate()
    {
        NoticeMapperImpl noticeMapper= new NoticeMapperImpl();
        Notice notice=new Notice();
        notice.setId(3);
        notice.setTitle("铁矿石含量");
        notice.setDate("2013/9/1");
        notice.setContent("该年铁矿石增长");
        int update=noticeMapper.Update(notice);
       if(update==1)
       {
           System.out.println("true");
       }
       else {
           System.out.println("false");
       }
    }
    public  void testDelete()
    {
        NoticeMapperImpl noticeMapper= new NoticeMapperImpl();
        Notice notice=new Notice();
        notice.setId(4);
        notice.setIs_deleted(1);
        int delete=noticeMapper.Delete(notice);
       if(delete==1)
       {
           System.out.println("true");
       }
       else {
           System.out.println("false");
       }
    }
    public  void testInsert()
    {
        NoticeMapperImpl noticeMapper= new NoticeMapperImpl();
        Notice notice=new Notice();
        notice.setTitle("黄金产粮");
        notice.setDate("2010/10/2");
        notice.setContent("黄金产量增长");
        int insert=noticeMapper.Insert(notice);
        if(insert==1)
        {
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

    }
}
