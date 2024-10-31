package com.sankar.rotary.members2lead;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LeadPojo {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int lId;
private String lName;
private String lDesig;
private String lUrl;

    public LeadPojo() {
    }

    public LeadPojo(int lId, String lName, String lDesig, String lUrl) {
        this.lId = lId;
        this.lName = lName;
        this.lDesig = lDesig;
        this.lUrl = lUrl;
    }

    public int getlId() {
        return lId;
    }
    public void setlId(int lId) {
        this.lId = lId;
    }

    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlDesig() {
        return lDesig;
    }
    public void setlDesig(String lDesig) {
        this.lDesig = lDesig;
    }

    public String getlUrl() {
        return lUrl;
    }
    public void setlUrl(String lUrl) {
        this.lUrl = lUrl;
    }

    @Override
    public String toString() {
        return "LeadPojo{" +
                "lId=" + lId +
                ", lName='" + lName + '\'' +
                ", lDesig='" + lDesig + '\'' +
                ", lUrl='" + lUrl + '\'' +
                '}';
    }
}
