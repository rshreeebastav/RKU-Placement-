package com.example.rkuplace;



public class Modelcomplaint {
    //Initialization
    String FullName,Email,Phone,Description;

    //Constructor
    public Modelcomplaint(String fullName, String email, String phone, String description) {
        FullName = fullName;
        Email = email;
        Phone = phone;
        Description = description;
    }


    //Getter and setter
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
