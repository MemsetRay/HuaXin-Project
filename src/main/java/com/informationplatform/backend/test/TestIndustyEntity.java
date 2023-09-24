package com.informationplatform.backend.test;

import com.informationplatform.backend.mapper.impl.IndustyMapperImpl;
import com.informationplatform.backend.pojo.Industy;

import java.util.ArrayList;
import java.util.List;

public class TestIndustyEntity {
    public static void main(String[] args) {
        IndustyMapperImpl i = new IndustyMapperImpl();
        Industy in=new Industy();
        List<Industy> lst=new ArrayList<>();
        in.setName("aaa");
        in.setEnterpriseId(1);
        in.setOutputId(1);
        in.setProductId(2);
        in.setId(10);
       // i.insert(in);
//        if (i.delete(in)>0) {
//            System.out.println("shcn");
//        }
//        i.selectAll();

//        lst=i.selectTolist();
//        System.out.println("---------");
//        for (IndustyEntity industyEntity : lst) {
//            System.out.println(industyEntity.getId());
//
//        }
//        if (i.update(in)>0) {
//            System.out.println("更新成功");
//        }

    }
}
