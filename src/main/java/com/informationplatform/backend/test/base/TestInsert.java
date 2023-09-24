package com.informationplatform.backend.test.base;

import com.informationplatform.backend.mapper.impl.BaseMapperImpl;
import com.informationplatform.backend.pojo.Base;

public class TestInsert {
    public static void main(String[] args) {
        BaseMapperImpl baseMapperImpl = new BaseMapperImpl();
        Base base = new Base("b5","i5","l5",1);
        baseMapperImpl.insert(base);
    }
}
