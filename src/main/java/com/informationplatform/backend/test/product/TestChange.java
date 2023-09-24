package com.informationplatform.backend.test.product;

import com.informationplatform.backend.mapper.impl.ProductMapperImpl;
import com.informationplatform.backend.pojo.Product;

public class TestChange {
    public static void main(String[] args) {
        ProductMapperImpl productMapperImpl = new ProductMapperImpl();
        Product product = productMapperImpl.getByProductId(1);
        product.setIntroduction("qweqweqweqweqweqweqweqwe");
        product.setName("pp1");
        productMapperImpl.change(product);
    }
}
