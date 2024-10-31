package com.sankar.rotary.members1dig;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DigPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dId;
    private String dName;
    private String dDesig;
    private String dUrl;

    public DigPojo() {
    }

    public DigPojo(int dId, String dName, String dDesig, String dUrl) {
        this.dId = dId;
        this.dName = dName;
        this.dDesig = dDesig;
        this.dUrl = dUrl;
    }

    public int getdId() {
        return dId;
    }
    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }
    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdDesig() {
        return dDesig;
    }
    public void setdDesig(String dDesig) {
        this.dDesig = dDesig;
    }

    public String getdUrl() {
        return dUrl;
    }
    public void setdUrl(String dUrl) {
        this.dUrl = dUrl;
    }

    @Override
    public String toString() {
        return "DigPojo{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                ", dDesig='" + dDesig + '\'' +
                ", dUrl='" + dUrl + '\'' +
                '}';
    }
}
