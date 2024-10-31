package com.sankar.rotary.home1platime;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Home1Pojo {

    @Id
    private int h1pId = 1;
    private String meetingPl;
    private String meetingDati;

    //constructors
    public Home1Pojo() {
    }
    public Home1Pojo(int h1pId,
                     String meetingPl,
                     String meetingDati) {
        this.h1pId = h1pId;
        this.meetingPl = meetingPl;
        this.meetingDati = meetingDati;
    }

    //getters and setters
    public int getH1pId() {
        return h1pId;
    }

    public String getMeetingPl() {
        return meetingPl;
    }

    public void setMeetingPl(String meetingPl) {
        this.meetingPl = meetingPl;
    }

    public String getMeetingDati() {
        return meetingDati;
    }

    public void setMeetingDati(String meetingDati) {
        this.meetingDati = meetingDati;
    }


    @Override
    public String toString() {
        return "Home1Pojo{" +
                "h1pId=" + h1pId +
                ", meetingPl='" + meetingPl + '\'' +
                ", meetingDati='" + meetingDati + '\'' +
                '}';
    }
}
