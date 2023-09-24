package com.informationplatform.backend.pojo;

public class Base {
    private int id;
    private String name;
    private String introduction;
    private int is_deleted;
    private String location;

    private int cityId;

    public Base() {
    }

    public Base(String name, String introduction, String location, int cityId) {
        this.name = name;
        this.introduction = introduction;
        this.location = location;
        this.cityId = cityId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
