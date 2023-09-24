package com.informationplatform.backend.pojo;

public class Notice {
    private  int id;
    private  String title;

    public Notice() {
    }


    private  String  date;
    private  String content;


    public Notice(int id, String title, String date, String content, int is_deleted) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.content = content;
        this.is_deleted = is_deleted;
    }

    private  int is_deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }



}
