package com.hb.platform.notemanager.domain.note;

import java.util.UUID;

public class NoteModel {

    private Long id;
    private Long userId;
    private String text;

    public NoteModel() {
    }

    public NoteModel(Long id, Long userId, String text) {
        this.id = id;
        this.userId = userId;
        this.text = text;
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
