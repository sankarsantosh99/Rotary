package com.sankar.rotary.members3mem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MemPojo {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int mId;
 private String mName;
 private String mUrl;

 public MemPojo() {
 }

 public MemPojo(int mId, String mName, String mUrl) {
  this.mId = mId;
  this.mName = mName;
  this.mUrl = mUrl;
 }

 public int getmId() {
  return mId;
 }
 public void setmId(int mId) {
  this.mId = mId;
 }

 public String getmName() {
  return mName;
 }
 public void setmName(String mName) {
  this.mName = mName;
 }

 public String getmUrl() {
  return mUrl;
 }
 public void setmUrl(String mUrl) {
  this.mUrl = mUrl;
 }

 @Override
 public String toString() {
  return "MemPojo{" +
          "mId=" + mId +
          ", mName='" + mName + '\'' +
          ", mUrl='" + mUrl + '\'' +
          '}';
 }
}
