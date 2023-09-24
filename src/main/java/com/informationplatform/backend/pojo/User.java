package com.informationplatform.backend.pojo;

public class User {
    private int id;
    private String name;
    private String password;
    private String enterprise;
    private String telephone;
    private String email;

    public User() {
    }

    public User(String name, String password, String enterprise, String telephone, String email, int baseId, int industryId, String base, String industry, String enterprisePhoto) {
        this.name = name;
        this.password = password;
        this.enterprise = enterprise;
        this.telephone = telephone;
        this.email = email;
        this.baseId = baseId;
        this.industryId = industryId;
        this.base = base;
        this.industry = industry;
        this.enterprisePhoto = enterprisePhoto;
    }

    private int baseId;
    private int industryId;
    private String base;
    private String industry;
    private String enterprisePhoto;
    private int isDeleted;

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getBaseId() {
        return baseId;
    }

    public void setBaseId(int baseId) {
        this.baseId = baseId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getEnterprisePhoto() {
        return enterprisePhoto;
    }

    public void setEnterprisePhoto(String enterprisePhoto) {
        this.enterprisePhoto = enterprisePhoto;
    }


}
