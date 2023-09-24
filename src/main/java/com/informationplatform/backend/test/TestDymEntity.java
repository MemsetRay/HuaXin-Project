package com.informationplatform.backend.test;

import com.informationplatform.backend.mapper.impl.DymMapperImpl;
import com.informationplatform.backend.pojo.Dym;

import java.util.Arrays;
import java.util.List;

public class TestDymEntity {
    public static void main(String[] args) {
        DymMapperImpl d = new DymMapperImpl();
        Dym dym = new Dym();
        dym.setId(1);
        dym.setTitle("dasdasdasdas");
        dym.setContent("sdasdasdasdasdasdasd");
        Dym dd=d.select(dym);
        System.out.println(dd.getTitle());

//        List<DymEntity> lst=d.selectTolist();
//        for (DymEntity dymEntity : lst) {
//            System.out.println(dymEntity.getId());
//            System.out.println(dymEntity.getTitle());
//            System.out.println(dymEntity.getContent());
//            System.out.println(dymEntity.getTime());
//
//        }
//        System.out.println("-------------------");

//        if (d.delete(dym) > 0) {
//            System.out.println("删除成功");
//        }


//        if (d.update(dym)>0) {
//            System.out.println("更新成功");
//
//        }
//        if (d.insert(dym)>0) {
//            System.out.println("插入成功");
//        }
//        System.out.println("-------------------");
//        d.selectAll();

    }

}
