package com.hb.platform.notemanager.domain.note;

import com.hb.platform.notemanager.domain.user.User;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CreateNoteModel {

    private Long userId;

    @NotNull
    private String text;

    public Note toEntity(User user) {
        Note note = new Note();
        note.setUser(user);
        note.setText(text);
        note.setCreatedTime(LocalDateTime.now());
        return note;
    }

    public String getText() {
        return text;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setText(String text) {
        this.text = text;
    }
}
