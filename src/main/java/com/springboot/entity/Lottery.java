package com.springboot.entity;

import org.apache.ibatis.annotations.Mapper;


public class Lottery {
    private int phase;
    private String date;
    private int red1;
    private int red2;
    private int red3;
    private int red4;
    private int red5;
    private int blue1;
    private int blue2;

    public int getPhase() {
        return phase;
    }
    public void setPhase(int phase) {
        this.phase = phase;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getRed1() {
        return red1;
    }
    public void setRed1(int red1) {
        this.red1 = red1;
    }
    public int getRed2() {
        return red2;
    }
    public void setRed2(int red2) {
        this.red2 = red2;
    }
    public int getRed3() {
        return red3;
    }
    public void setRed3(int red3) {
        this.red3 = red3;
    }
    public int getRed4() {
        return red4;
    }
    public void setRed4(int red4) {
        this.red4 = red4;
    }
    public int getRed5() {
        return red5;
    }
    public void setRed5(int red5) {
        this.red5 = red5;
    }
    public int getBlue1() {
        return blue1;
    }
    public void setBlue1(int blue1) {
        this.blue1 = blue1;
    }
    public int getBlue2() {
        return blue2;
    }
    public void setBlue2(int blue2) {
        this.blue2 = blue2;
    }
}
