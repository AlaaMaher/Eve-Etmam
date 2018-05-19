package com.alaaetmam.eve.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {

    private int Id;
    private String FullName;
    private boolean Archive;
    private String  DateOfBirth;
    private String  Email;
    private String Gender;
    private String PersonProfile;
    private int Stars;
    private Names[]Services;
    private String[] Images;
    private Location[] Location;

    public Person(int Id,String FullName,boolean Archive,String DateOfBirth,String Email,String Gender,String PersonProfile,int Stars,Names[] Services,String[] Images,Location[] Location){
        this.Id=Id;
        this.FullName=FullName;
        this.Archive=Archive;
        this.DateOfBirth=DateOfBirth;
        this.Email=Email;
        this.Gender=Gender;
        this.PersonProfile=PersonProfile;
        this.Stars=Stars;
        this.Services=Services;
        this.Images=Images;
        this.Location=Location;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public boolean isArchive() {
        return Archive;
    }

    public void setArchive(boolean archive) {
        Archive = archive;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getStars() {
        return Stars;
    }

    public void setStars(int stars) {
        Stars = stars;
    }

    public Names[] getServices() {
        return Services;
    }

    public void setServices(Names[] services) {
        Services = services;
    }

    public String[] getImages() {
        return Images;
    }

    public void setImages(String[] images) {
        Images = images;
    }

    public com.alaaetmam.eve.Model.Location[] getLocation() {
        return Location;
    }

    public void setLocation(com.alaaetmam.eve.Model.Location[] location) {
        Location = location;
    }

    public String getPersonProfile() {
        return PersonProfile;
    }

    public void setPersonProfile(String personProfile) {
        PersonProfile = personProfile;
    }
}
