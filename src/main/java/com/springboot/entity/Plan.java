package com.springboot.entity;

public class Plan {
    private int id;
    private String startdate;
    private String enddate;
    private String plan;
    private String content;
    private String assessment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartdate() {
        return startdate;
    }
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
    public String getEnddate() {
        return enddate;
    }
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
    public String getPlan() {
        return plan;
    }
    public void setPlan(String plan) {
        this.plan = plan;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getAssessment() {
        return assessment;
    }
    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }
}
