package com.supriya.roomdbwithimageanddate.DataModel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "User")
public class User {

    @PrimaryKey(autoGenerate = true)
    int uid;

    @ColumnInfo(name = "Name")
    String fullName;
    @ColumnInfo(name = "User_Name")
    String userName;
    String password;
    Date dob;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)//byte type data
    byte[] image;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
