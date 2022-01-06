package com.hb.platform.notemanager.user;

import com.hb.platform.notemanager.address.Address;
import com.hb.platform.notemanager.base.BaseEntity;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User extends BaseEntity {

    @Column(nullable = false)
    private String fistName;

    @Column(nullable = false)
    private String lastName;


    @Column(nullable = false, length = 50)
    private String email;

    @Column
    //TODO chnage number Variable name to phoneNumber
    private int phoneNumber;

    //TODO Change enumType to String
    @Enumerated(EnumType.STRING)
    private Role role;



    @OneToOne
    @JoinColumn(name = "address_id")
    //TODO change adminAddress -> address
    private Address address;

    public User() {
    }

    public User(String fistName, String lastName, String email, int phoneNumber, Role role, Address address) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.address = address;
    }

    public String getFistName() {
        return fistName;
    }

    public Address getAddress() {
        return address;
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

    public void setPhoneNumber(int number) {
        this.phoneNumber = number;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //TODO Add equals and hashcode for all entities

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return phoneNumber == user.phoneNumber && Objects.equals(fistName, user.fistName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && role == user.role && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fistName, lastName, email, phoneNumber, role, address);
    }
}
