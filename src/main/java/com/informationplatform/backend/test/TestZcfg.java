package com.informationplatform.backend.test;

import com.informationplatform.backend.mapper.impl.ZcfgMapperImpl;
import com.informationplatform.backend.pojo.Zcfg;

import java.util.List;

public class TestZcfg {
    public static void main(String[] args) {
        TestZcfg testZcfg = new TestZcfg();
        testZcfg.testSelectAll();
        //testZcfg.testSelectById();
        //testZcfg.testUpdate();
        //testZcfg.testInsert();
        //testZcfg.testDelete();
    }

    private void testSelectAll() {
        ZcfgMapperImpl zcfgMapper = new ZcfgMapperImpl();
        List<Zcfg> list = zcfgMapper.SelectAll();
        for (Zcfg zcfg : list) {
            System.out.print(zcfg.getId() + "\t");
            System.out.print(zcfg.getTopic() + "\t");
            System.out.print(zcfg.getLianjie() + "\t");
            System.out.print(zcfg.getFujianlianjie() + "\t");
            System.out.println(zcfg.getIs_deleted() + "\t");
        }
    }

    public void testSelectById() {
        ZcfgMapperImpl zcfgMapper = new ZcfgMapperImpl();
        Zcfg zcfg = zcfgMapper.SelectById(2);
        if (zcfg != null) {
            System.out.print(zcfg.getId() + "\t");
            System.out.print(zcfg.getTopic() + "\t");
            System.out.print(zcfg.getNumber() + "\t");
            System.out.print(zcfg.getLianjie() + "\t");
            System.out.print(zcfg.getFujianlianjie() + "\t");
        } else {
            System.out.println("false");
        }
    }

    public void testUpdate() {
        ZcfgMapperImpl zcfgMapper = new ZcfgMapperImpl();
        Zcfg zcfg = new Zcfg();
        zcfg.setId(2);
        zcfg.setTopic("欢迎来到出口基地公共平台");
        int update = zcfgMapper.Update(zcfg);
        if (update == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    public void testInsert() {
        ZcfgMapperImpl zcfgMapper = new ZcfgMapperImpl();
        Zcfg zcfg = new Zcfg();
        zcfg.setTopic("中日企业合作法律一览");
        int insert = zcfgMapper.Insert(zcfg);
        if (insert == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public void testDelete() {
        ZcfgMapperImpl cityMapper = new ZcfgMapperImpl();
        Zcfg zcfg = new Zcfg();
        zcfg.setId(7);
        zcfg.setIs_deleted(1);
        int delete = cityMapper.Delete(zcfg);
        if (delete == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}

