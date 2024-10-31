package com.sankar.rotary.aboutcarousel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class AboutPojo {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int abId;
    private String abUrl;

    public AboutPojo() {
    }
    public AboutPojo(int abId, String abUrl) {
        this.abId = abId;
        this.abUrl = abUrl;
    }

    public int getAbId() {
        return abId;
    }
    public void setAbId(int abId) {
        this.abId = abId;
    }

    public String getAbUrl() {
        return abUrl;
    }
    public void setAbUrl(String abUrl) {
        this.abUrl = abUrl;
    }

    @Override
    public String toString() {
        return "AboutPojo{" +
                "abId=" + abId +
                ", abUrl='" + abUrl + '\'' +
                '}';
    }
}
