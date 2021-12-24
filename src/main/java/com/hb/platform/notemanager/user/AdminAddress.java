package com.hb.platform.notemanager.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminAddress {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String street1;
    private String street2;
    private String city;
    private String country;
    private int postalCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AdminAddress(String street1, String street2, String city, String country, int postalCode) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

    public AdminAddress() {

    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
}
