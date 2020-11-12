package com.example.domain.model;



public class UserModel {
    private int profilePicture;
    private String fullName;
    private  String email;



    public UserModel(int profilePicture, String fullName, String email ){
        this.profilePicture = profilePicture;
        this.fullName = fullName;
        this.email = email;
    }



    public UserModel (){
    }
    public int getProfilePicture() { return profilePicture;}

    public void setProfilePicture(int profilePicture) { this.profilePicture = profilePicture;}

    public String getFullName() {return fullName;}

    public void setFullName(String fullName) {this.fullName = fullName;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}
