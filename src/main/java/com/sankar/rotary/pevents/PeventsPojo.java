package com.sankar.rotary.pevents;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PeventsPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int peId;
    private String peDm;
    private String peYear;
    private String peTitle;
    private String peDesc;
    private String peUrl;

    public PeventsPojo() {
    }
    public PeventsPojo(int peId, String peDm, String peYear,
                       String peTitle, String peDesc,
                       String peUrl) {
        this.peId = peId;
        this.peDm = peDm;
        this.peYear = peYear;
        this.peTitle = peTitle;
        this.peDesc = peDesc;
        this.peUrl = peUrl;
    }

    public int getPeId() {
        return peId;
    }
    public void setPeId(int peId) {
        this.peId = peId;
    }

    public String getPeDm() {
        return peDm;
    }
    public void setPeDm(String peDm) {
        this.peDm = peDm;
    }

    public String getPeYear() {
        return peYear;
    }
    public void setPeYear(String peYear) {
        this.peYear = peYear;
    }

    public String getPeTitle() {
        return peTitle;
    }
    public void setPeTitle(String peTitle) {
        this.peTitle = peTitle;
    }

    public String getPeDesc() {
        return peDesc;
    }
    public void setPeDesc(String peDesc) {
        this.peDesc = peDesc;
    }

    public String getPeUrl() {
        return peUrl;
    }
    public void setPeUrl(String peUrl) {
        this.peUrl = peUrl;
    }

    @Override
    public String toString() {
        return "PeventsPojo{" +
                "peId=" + peId +
                ", peDm='" + peDm + '\'' +
                ", peYear='" + peYear + '\'' +
                ", peTitle='" + peTitle + '\'' +
                ", peDesc='" + peDesc + '\'' +
                ", peUrl='" + peUrl + '\'' +
                '}';
    }
}
