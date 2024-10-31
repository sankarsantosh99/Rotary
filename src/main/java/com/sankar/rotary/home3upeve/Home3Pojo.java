package com.sankar.rotary.home3upeve;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Home3Pojo {

    @Id
    private int h3Id=1;
    private String upEvent;

    //constructors
    public Home3Pojo() {
    }

    public Home3Pojo(int h3Id, String upEvent) {
        this.h3Id = h3Id;
        this.upEvent = upEvent;
    }

    //getters and setters
    public int getH3Id() {
        return h3Id;
    }

    public String getUpEvent() {
        return upEvent;
    }
    public void setUpEvent(String upEvent) {
        this.upEvent = upEvent;
    }

    @Override
    public String toString() {
        return "Home3Pojo{" +
                "h3Id=" + h3Id +
                ", upEvent='" + upEvent + '\'' +
                '}';
    }
}
