package com.hb.platform.notemanager.note;

import com.hb.platform.notemanager.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

   public List<Note> getNotes() {
        return noteRepository.findAll();
    }

   public void deleteNote(long id) {
        noteRepository.deleteById(id);
    }

    @Transactional
    public void addNewNote(Note note) {
        noteRepository.save(note);

    }


    @Transactional
    Note update(Long id, String text) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("c"));
        note.setText(text);

        noteRepository.save(note);
        return note;
    }

}
