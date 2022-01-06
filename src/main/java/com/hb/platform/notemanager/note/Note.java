package com.hb.platform.notemanager.note;


import com.hb.platform.notemanager.base.BaseEntity;
import com.hb.platform.notemanager.user.User;

import javax.persistence.*;

@Entity
public class Note extends BaseEntity {

    @ManyToOne
    private User user;

    @Column(length = 10000, nullable = false)
    private String text;

    public Note(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public Note() {
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
