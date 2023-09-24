package com.informationplatform.backend.pojo;

public class Fwpt {
    private int id;
    private String information;
    private String question;
    private String idea;
    private int is_deleted;

    public Fwpt() {
    }

    public int getId() {
        return id;
    }

    public  void setId(int id) { this.id = id;
    }

    public String getInformation() {
        return this.information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

}