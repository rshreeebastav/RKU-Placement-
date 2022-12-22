package com.example.rkuplace;

public class Modelcontact {

    //Initialization
    String Name,Email,Phone,Subject,Message;


    //Getter and setter
    public Modelcontact(String name, String email, String phone, String subject, String message) {
        Name = name;
        Email = email;
        Phone = phone;
        Subject = subject;
        Message = message;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
