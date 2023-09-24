package com.informationplatform.backend.test.product;

import com.informationplatform.backend.mapper.impl.ProductMapperImpl;
import com.informationplatform.backend.pojo.Product;

public class TestInsert {
    public static void main(String[] args) {
        ProductMapperImpl productMapperImpl = new ProductMapperImpl();
        Product product = new Product(3,"p3","m3","i3","in3","p3","b3","pro3",10);
        productMapperImpl.insert(product);
    }
}
