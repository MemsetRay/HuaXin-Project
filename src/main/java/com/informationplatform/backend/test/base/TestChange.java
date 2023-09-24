package com.informationplatform.backend.test.base;

import com.informationplatform.backend.mapper.impl.BaseMapperImpl;
import com.informationplatform.backend.pojo.Base;

public class TestChange {
    public static void main(String[] args) {
        BaseMapperImpl baseMapperImpl = new BaseMapperImpl();
        Base base = baseMapperImpl.getByBaseId(1);
        base.setName("cb1");
        baseMapperImpl.change(base);
    }
}
