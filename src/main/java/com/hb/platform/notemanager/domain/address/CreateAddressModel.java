package com.hb.platform.notemanager.domain.address;

public class CreateAddressModel {
    private String street1;
    private String street2;
    private String city;
    private String country;
    private int postalCode;

    public Address toEntity() {
        Address address = new Address();
        address.setStreet1(street1);
        address.setStreet2(street2);
        address.setCity(city);
        address.setCountry(country);
        address.setPostalCode(postalCode);
        return address;
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
