package com.informationplatform.backend.test.product;

import com.informationplatform.backend.mapper.impl.ProductMapperImpl;
import com.informationplatform.backend.pojo.Product;

import java.util.List;

public class TestGetByProductId {
    public static void main(String[] args) {
        ProductMapperImpl productMapperImpl = new ProductMapperImpl();
        Product product = productMapperImpl.getByProductId(2);
        System.out.println(product.getName() + " " + product.getUserId() + " " + product.getId() + " " + product.getIntroduction());
    }
}
