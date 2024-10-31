package com.sankar.rotary.home2theme;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Home2Pojo {
    @Id
    private int h2Id=1;
    private String thYear;
    private String fileName;

    //constructors
    public Home2Pojo() {
    }

    public Home2Pojo(int h2Id) {
        this.h2Id = h2Id;
    }
    public Home2Pojo(int id, String fileName,
                     String thYear) {
        this.h2Id = id;
        this.fileName = fileName;
        this.thYear = thYear;
    }

//getters and setters
    public int getH2Id() {
        return h2Id;
    }

    public String getThYear() {
        return thYear;
    }
    public void setThYear(String thYear) {
        this.thYear = thYear;
    }


    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Home2Pojo{" +
                "id=" + h2Id +
                ", thYear='" + thYear + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
