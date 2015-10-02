package com.vnadgir.hal.api.model;

import org.joda.time.DateTime;

public class PersonalDetails {

    private final String firstname;
    private final String lastname;
    private final DateTime testEndDateTime;
    private final String email;
    private final String phone;
    private final Gender gender;
    private final String city;
    private final String country;
    private final DateTime dateOfBirth;

    public PersonalDetails(String firstname, String lastname, DateTime testEndDateTime, String email, String phone, Gender gender, String city, String country, DateTime dateOfBirth) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.testEndDateTime = testEndDateTime;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.city = city;
        this.country = country;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public DateTime getTestEndDateTime() {
        return testEndDateTime;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Gender getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public DateTime getDateOfBirth() {
        return dateOfBirth;
    }
}
