package com.example.chatwale.Models;

public class User {

    private String uid,name,phoneNumberOfUser,profileImage;


    public User(){
        //empty constructor should be there whenever we're working with Firebase.
    }

    //Below is constructor
    public User(String uid, String name, String phoneNumberOfUser, String profileImage) {
        this.uid = uid;
        this.name = name;
        this.phoneNumberOfUser = phoneNumberOfUser;
        this.profileImage = profileImage;
    }

    //Below are getter and setter


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumberOfUser() {
        return phoneNumberOfUser;
    }

    public void setPhoneNumberOfUser(String phoneNumberOfUser) {
        this.phoneNumberOfUser = phoneNumberOfUser;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
