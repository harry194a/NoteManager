package com.hb.platform.notemanager.domain.note;

import com.hb.platform.notemanager.domain.base.BaseEntity;
import com.hb.platform.notemanager.domain.user.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Note extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(length = 10000, nullable = false)
    private String text;

    @Column()
    private LocalDateTime createdTime;


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

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
