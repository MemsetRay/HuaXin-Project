package com.informationplatform.backend.mapper;

import com.informationplatform.backend.pojo.Product;

import java.util.List;

public interface ProductMapper {
    /**
     * 根据ProductId查询Product
     * @param productId
     * @return
     */
    Product getByProductId (int productId);

    /**
     * 根据UserId查询Product
     * @param userId
     * @return
     */
    List<Product> getByUserId (int userId);

    /**
     * 根据IndustryId查询Product
     * @param industryId
     * @return
     */
    List<Product> getByIndustryId (int industryId);

    List<Product> getAllProduct ();

    /**
     * 插入一个Product
     * @param product
     */
    void insert (Product product);

    /**
     * 修改一个Product
     * @param product
     */
    void change (Product product);

    /**
     * 删除一个Product
     * @param productId
     */
    void delete (int productId);
}
