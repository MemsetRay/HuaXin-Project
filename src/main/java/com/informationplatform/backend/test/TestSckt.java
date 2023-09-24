package com.informationplatform.backend.test;

import com.informationplatform.backend.mapper.impl.ScktMapperImpl;
import com.informationplatform.backend.pojo.Sckt;

import java.util.List;

public class TestSckt {
    public static void main(String[] args) {
        TestSckt testSckt = new TestSckt();
        testSckt.testSelectAll();
        //testSckt.testSelectById();
        //testSckt.testUpdate();
        //testSckt.testInsert();
        //testSckt.testDelete();
    }

    private void testSelectAll() {
        ScktMapperImpl scktMapper = new ScktMapperImpl();
        List<Sckt> list = scktMapper.SelectAll();
        for (Sckt sckt : list) {
            System.out.print(sckt.getId() + "\t");
            System.out.print(sckt.getSobject() + "\t");
            System.out.print(sckt.getDemand1() + "\t");
            System.out.print(sckt.getInvestment() + "\t");
            System.out.print(sckt.getPlan() + "\t");
            System.out.print(sckt.getFeedback() + "\t");
            System.out.print(sckt.getTheway() + "\t");
            System.out.print(sckt.getSummarize() + "\t");
            System.out.println(sckt.getIs_deleted() + "\t");
        }
    }

    public void testSelectById() {
        ScktMapperImpl scktMapper = new ScktMapperImpl();
        Sckt sckt = scktMapper.SelectById(2);
        if (sckt != null) {
            System.out.print(sckt.getId() + "\t");
            System.out.print(sckt.getSobject() + "\t");
            System.out.println(sckt.getDemand1() + "\t");
            System.out.print(sckt.getInvestment() + "\t");
            System.out.print(sckt.getPlan() + "\t");
            System.out.print(sckt.getFeedback() + "\t");
            System.out.print(sckt.getTheway() + "\t");
            System.out.print(sckt.getSummarize() + "\t");
            System.out.println(sckt.getIs_deleted() + "\t");
        } else {
            System.out.println("false");
        }
    }

    public void testUpdate() {
        ScktMapperImpl scktMapper = new ScktMapperImpl();
        Sckt sckt = new Sckt();
        sckt.setId(3);
        sckt.setSobject("市场十二");
        int update = scktMapper.Update(sckt);
        if (update == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}

