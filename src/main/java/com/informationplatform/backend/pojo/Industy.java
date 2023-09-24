package com.informationplatform.backend.pojo;

public class Industy {
    private int id;
    private String name;
    private int enterpriseId;//企业id,
    private int outputId;//出口id;
    private int productId;
    private int is_deleted;

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Industy()
    {

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Industy(String name, int enterpriseId, int outputId, int productId) {
        this.name = name;
        this.enterpriseId = enterpriseId;
        this.outputId = outputId;
        this.productId=productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public int getOutputId() {
        return outputId;
    }

    public void setOutputId(int outputId) {
        this.outputId = outputId;
    }
}
