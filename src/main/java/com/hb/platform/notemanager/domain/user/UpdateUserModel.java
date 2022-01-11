package com.hb.platform.notemanager.domain.user;

import com.hb.platform.notemanager.domain.address.Address;
import com.hb.platform.notemanager.domain.address.CreateAddressModel;
import com.hb.platform.notemanager.domain.base.Role;

import javax.validation.constraints.NotNull;

public class UpdateUserModel {

    @NotNull
    private String fistName;

    @NotNull
    private String lastName;

    @NotNull
    private int phoneNumber;

    @NotNull
    private Role role;

    @NotNull
    private CreateAddressModel address;

    public User toUserUpdate(User user, Address address, long id) {
        user.setFistName(fistName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setId(id);
        return user;
    }


    public CreateAddressModel getAddress() {
        return address;
    }

    public void setAddress(CreateAddressModel address) {
        this.address = address;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Role getRole() {
        return role;
    }
}
