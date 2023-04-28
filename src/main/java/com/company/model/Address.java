package com.company.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address  {

    private String street;

    private String road;

    private int postCode;

    private String city;

    public Address() {
    }

    public Address(String street, String road, int postCode, String city) {
        this.street = street;
        this.road = road;
        this.postCode = postCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", road='" + road + '\'' +
                ", postCode=" + postCode +
                ", city='" + city + '\'' +
                '}';
    }
}
