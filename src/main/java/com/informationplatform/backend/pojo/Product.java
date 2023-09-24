package com.informationplatform.backend.pojo;

public class Product {
    private int id;
    private int userId;
    private String name;
    private String model;
    private String industry;
    private String introduction;
    private String photo;
    private String brand;
    private String producer;
    private int industryId;
    private int isDeleted;

    public Product() {
    }

    public Product(int userId, String name, String model, String industry, String introduction, String photo, String brand, String producer, int industryId) {
        this.userId = userId;
        this.name = name;
        this.model = model;
        this.industry = industry;
        this.introduction = introduction;
        this.photo = photo;
        this.brand = brand;
        this.producer = producer;
        this.industryId = industryId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getIndustryId() {
        return industryId;
    }

    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
