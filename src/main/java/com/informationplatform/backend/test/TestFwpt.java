package com.informationplatform.backend.test;

import com.informationplatform.backend.mapper.impl.FwptMapperImpl;
import com.informationplatform.backend.pojo.Fwpt;

import java.util.List;

public class TestFwpt {
    public static void main(String[] args) {
        TestFwpt testFwpt=new TestFwpt();
        testFwpt.testSelectAll();
        //testFwpt.testSelectById();
        //testFwpt.testUpdate();
        //testFwpt.testInsert();
        //testFwpt.testDelete();
    }
    public  void testSelectAll()
    {
        FwptMapperImpl cityMapper=new FwptMapperImpl();
        List<Fwpt> list=cityMapper.SelectAll();
        for(Fwpt fwpt:list)
        {
            System.out.print(fwpt.getId()+"\t");
            System.out.print(fwpt.getInformation()+"\t");
            System.out.println(fwpt.getQuestion()+"\t");
            System.out.println(fwpt.getIdea()+"\t");
            System.out.println(fwpt.getIs_deleted()+"\t");
        }
    }
    public  void  testSelectById()
    {
        FwptMapperImpl fwptMapper=new FwptMapperImpl();
        Fwpt fwpt=fwptMapper.SelectById(2);
        if (fwpt!=null)
        {
            System.out.print(fwpt.getId()+"\t");
            System.out.print(fwpt.getInformation()+"\t");
            System.out.print(fwpt.getQuestion()+"\t");
            System.out.print(fwpt.getIdea()+"\t");
            System.out.println(fwpt.getIs_deleted()+"\t");
        }
        else {
            System.out.println("false");
        }
    }
    public  void testUpdate()
    {
        FwptMapperImpl fwptMapper=new FwptMapperImpl();
        Fwpt fwpt=new Fwpt();
        fwpt.setId(7);
        fwpt.setInformation("沈阳是辽宁省会");
        int update=fwptMapper.Update(fwpt);
        if(update==1)
        {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

    }
    public  void testInsert()
    {
        FwptMapperImpl cityMapper=new FwptMapperImpl();
        Fwpt city=new Fwpt();
        city.setInformation("日本的首都是东京");
        int insert=cityMapper.Insert(city);
        if(insert==1)
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }
    }

