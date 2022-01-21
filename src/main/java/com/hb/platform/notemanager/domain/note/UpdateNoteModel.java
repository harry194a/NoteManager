package com.hb.platform.notemanager.domain.note;

public class UpdateNoteModel {

    private Long userId;

    String text;

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
