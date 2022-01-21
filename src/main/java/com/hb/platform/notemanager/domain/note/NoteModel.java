package com.hb.platform.notemanager.domain.note;

import java.time.LocalDateTime;

public class NoteModel {

    private Long id;
    private Long userId;
    private String text;
    private LocalDateTime localDate;



    public NoteModel(Long id, Long userId, String text, LocalDateTime localDate) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.localDate = localDate;
    }

    public LocalDateTime getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDateTime localDate) {
        this.localDate = localDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
