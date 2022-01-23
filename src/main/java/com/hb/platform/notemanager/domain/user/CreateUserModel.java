package com.hb.platform.notemanager.domain.user;

import com.hb.platform.notemanager.domain.address.Address;
import com.hb.platform.notemanager.domain.address.CreateAddressModel;
import com.hb.platform.notemanager.domain.base.Role;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CreateUserModel {

    @NotEmpty
    @Size(min = 3)
    private String fistName;
    private String lastName;
    private String email;
    private String password;
    private int phoneNumber;
    private Role role;
    private CreateAddressModel address;

    public User toUser(Address address, String encodedPassword) {
        User user = new User();
        user.setFistName(fistName);
        user.setLastName(lastName);
        user.setPassword(encodedPassword);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        return user;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public CreateAddressModel getAddress() {
        return address;
    }

    public void setAddress(CreateAddressModel address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
