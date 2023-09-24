package com.informationplatform.backend.test.product;

import com.informationplatform.backend.mapper.impl.ProductMapperImpl;
import com.informationplatform.backend.pojo.Product;

import java.util.List;

public class TestGetByUserId {
    public static void main(String[] args) {
        ProductMapperImpl productMapperImpl = new ProductMapperImpl();
        List<Product> productList = productMapperImpl.getByUserId(1);
        for (Product product : productList) {
            System.out.println(product.getName() + " " + product.getUserId() + " " + product.getId() + " " + product.getIntroduction());
        }
    }
}
