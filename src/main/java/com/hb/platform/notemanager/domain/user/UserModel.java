package com.hb.platform.notemanager.domain.user;

import com.hb.platform.notemanager.domain.address.Address;
import com.hb.platform.notemanager.domain.base.Role;

import javax.validation.constraints.NotNull;

public class UserModel {
    @NotNull
    private String fistName;

    @NotNull
    private String lastName;

    @NotNull
    private int phoneNumber;

    @NotNull
    private Role role;

    @NotNull
    private Address address;

    public UserModel() {
    }

    public UserModel(String fistName, String lastName, int phoneNumber, Role role, Address address) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.address = address;

    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}