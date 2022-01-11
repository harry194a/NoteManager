package com.hb.platform.notemanager.domain.note;

import com.hb.platform.notemanager.domain.base.BaseEntity;
import com.hb.platform.notemanager.domain.user.User;

import javax.persistence.*;

@Entity
public class Note extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
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
