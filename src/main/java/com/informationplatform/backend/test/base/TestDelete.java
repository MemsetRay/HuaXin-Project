package com.informationplatform.backend.test.base;

import com.informationplatform.backend.mapper.impl.BaseMapperImpl;

public class TestDelete {
    public static void main(String[] args) {
        BaseMapperImpl baseMapperImpl = new BaseMapperImpl();
        baseMapperImpl.delete(2);
    }
}
