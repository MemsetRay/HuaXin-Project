package com.informationplatform.backend.pojo;

import java.util.Date;

public class Zcfg {
    public String topic;
    private int id;
    private Date number;
    private String lianjie;
    private String fujianlianjie;
    public int is_deleted;

    public Zcfg() {
    }

    public  void set(String string) {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNumber() {
        return this.number;
    }

    public void setNumber(Date number) {
        this.number = number;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getLianjie() {
        return this.lianjie;
    }

    public void setLianjie(String lianjie) {
        this.lianjie = lianjie;
    }

    public String getFujianlianjie() {
        return this.fujianlianjie;
    }

    public void setFujianlianjie(String fujianlianjie) {
        this.fujianlianjie = fujianlianjie;
    }

    public int getIs_deleted() {
        return this.is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }
}
