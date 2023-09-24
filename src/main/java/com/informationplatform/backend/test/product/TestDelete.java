package com.informationplatform.backend.test.product;

import com.informationplatform.backend.mapper.impl.ProductMapperImpl;

public class TestDelete {
    public static void main(String[] args) {
        ProductMapperImpl productMapperImpl = new ProductMapperImpl();
        productMapperImpl.delete(3);
    }
}
