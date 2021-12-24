package com.hb.platform.notemanager.user;


import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue()
    private Long id;
    @Column(nullable = false)
    private String fistName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(length = 17)
    private int number;
    @Enumerated
    private Role role;


    @ManyToOne
    @JoinColumn(name = "admin_address_id")
    AdminAddress adminAddress;

    public User() {
    }

    public User(String fistName, String lastName, String email, int number, Role role, AdminAddress adminAddress) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
        this.role = role;
        this.adminAddress = adminAddress;
    }

    public AdminAddress getAdminAddress() {
        return adminAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAdminAddress(AdminAddress adminAddress) {
        this.adminAddress = adminAddress;
    }
}
