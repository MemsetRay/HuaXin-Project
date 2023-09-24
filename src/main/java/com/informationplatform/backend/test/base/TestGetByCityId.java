package com.informationplatform.backend.test.base;

import com.informationplatform.backend.mapper.impl.BaseMapperImpl;
import com.informationplatform.backend.pojo.Base;

import java.util.List;

public class TestGetByCityId {
    public static void main(String[] args) {
        BaseMapperImpl baseMapperImpl = new BaseMapperImpl();
        List<Base> baseList = baseMapperImpl.getByCityId(1);
        for (Base base : baseList) {
            System.out.println(base.getId() + " " + base.getName() + " " + base.getLocation());
        }
    }
}
