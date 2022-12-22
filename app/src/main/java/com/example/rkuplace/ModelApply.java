package com.example.rkuplace;


//Declaration
public class ModelApply {
    String enrollmentno,name,gender,dob,contact,email,institute,course	,specialization,cgpa,company_name;

    //constructor
    public ModelApply(String enrollmentno, String name, String gender, String dob, String contact, String email, String institute, String course, String specialization, String cgpa, String company_name) {
        this.enrollmentno = enrollmentno;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.contact = contact;
        this.email = email;

        this.institute = institute;
        this.course = course;
        this.specialization = specialization;
        this.cgpa = cgpa;
        this.company_name = company_name;
    }

    //Getter and setter
    public String getEnrollmentno() {
        return enrollmentno;
    }

    public void setEnrollmentno(String enrollmentno) {
        this.enrollmentno = enrollmentno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }


    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}

