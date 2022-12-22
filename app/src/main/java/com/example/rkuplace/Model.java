package com.example.rkuplace;

//Company Model
public class Model {

    //Declaration
    private int Id;
    String Name, Job_Description, Contract, Package, Training_Time, job_location, company_url, ctc, job_profile, date_joining, img, batch, eligible_course, registration_time, Contact, venue, date_time, registration_link, company_profile;

    //Constructor
    public Model(int id, String name, String job_Description, String contract, String aPackage, String training_Time, String job_location, String company_url, String ctc, String job_profile, String date_joining, String img, String batch, String eligible_course, String registration_time, String contact, String venue, String date_time, String registration_link, String company_profile) {
        Id = id;
        Name = name;
        Job_Description = job_Description;
        Contract = contract;
        Package = aPackage;
        Training_Time = training_Time;
        this.job_location = job_location;
        this.company_url = company_url;
        this.ctc = ctc;
        this.job_profile = job_profile;
        this.date_joining = date_joining;
        this.img = img;
        this.batch = batch;
        this.eligible_course = eligible_course;
        this.registration_time = registration_time;
        Contact = contact;
        this.venue = venue;
        this.date_time = date_time;
        this.registration_link = registration_link;
        this.company_profile = company_profile;
    }

    //Getter and setter
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getJob_Description() {
        return Job_Description;
    }

    public void setJob_Description(String job_Description) {
        Job_Description = job_Description;
    }

    public String getContract() {
        return Contract;
    }

    public void setContract(String contract) {
        Contract = contract;
    }

    public String getPackage() {
        return Package;
    }

    public void setPackage(String aPackage) {
        Package = aPackage;
    }

    public String getTraining_Time() {
        return Training_Time;
    }

    public void setTraining_Time(String training_Time) {
        Training_Time = training_Time;
    }

    public String getJob_location() {
        return job_location;
    }

    public void setJob_location(String job_location) {
        this.job_location = job_location;
    }

    public String getCompany_url() {
        return company_url;
    }

    public void setCompany_url(String company_url) {
        this.company_url = company_url;
    }

    public String getCtc() {
        return ctc;
    }

    public void setCtc(String ctc) {
        this.ctc = ctc;
    }

    public String getJob_profile() {
        return job_profile;
    }

    public void setJob_profile(String job_profile) {
        this.job_profile = job_profile;
    }

    public String getDate_joining() {
        return date_joining;
    }

    public void setDate_joining(String date_joining) {
        this.date_joining = date_joining;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getEligible_course() {
        return eligible_course;
    }

    public void setEligible_course(String eligible_course) {
        this.eligible_course = eligible_course;
    }

    public String getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(String registration_time) {
        this.registration_time = registration_time;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getRegistration_link() {
        return registration_link;
    }

    public void setRegistration_link(String registration_link) {
        this.registration_link = registration_link;
    }

    public String getCompany_profile() {
        return company_profile;
    }

    public void setCompany_profile(String company_profile) {
        this.company_profile = company_profile;
    }
}

//    public Model(int id, String name, String job_Description) {
//        Id = id;
//        Name = name;
//        Job_Description = job_Description;
//    }
//
//    public int getId() {
//        return Id;
//    }
//
//    public void setId(int id) {
//        Id = id;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String name) {
//        Name = name;
//    }
//
//    public String getJob_Description() {
//        return Job_Description;
//    }
//
//    public void setJob_Description(String job_Description) {
//        Job_Description = job_Description;
//    }
//}
