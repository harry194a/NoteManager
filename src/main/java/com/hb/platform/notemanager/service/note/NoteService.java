package com.hb.platform.notemanager.service.note;

import com.hb.platform.notemanager.domain.note.CreateNoteModel;
import com.hb.platform.notemanager.domain.note.Note;
import com.hb.platform.notemanager.domain.note.NoteModel;
import com.hb.platform.notemanager.repository.NoteRepository;
import com.hb.platform.notemanager.domain.user.User;
import com.hb.platform.notemanager.service.common.ModelValidator;
import com.hb.platform.notemanager.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {

    private static final Logger logger = LoggerFactory.getLogger(NoteService.class);

    private final NoteRepository noteRepository;
    private final UserService userService;
    private final ModelValidator modelValidator;


    @Autowired
    public NoteService(NoteRepository noteRepository, UserService userService, ModelValidator modelValidator) {
        this.noteRepository = noteRepository;
        this.userService = userService;
        this.modelValidator = modelValidator;
    }

    private List<NoteModel> getNoteModels(List<Note> userNotes) {
        List<NoteModel> noteModels = new ArrayList<>();
        for (Note note : userNotes) {
            noteModels.add(new NoteModel(note.getId(), note.getUser().getId(), note.getText()));
        }
        logger.info("Successfully retrieved notes result - {}", noteModels);
        return noteModels;
    }

    @Transactional
    public List<NoteModel> getNotes() {
        logger.info("Retrieve all notes");
        List<Note> notes = noteRepository.findAll();
        logger.info("Successfully retrieved notes result - {}", getNoteModels(notes));
        return getNoteModels(notes);
    }

    @Transactional
    public List<NoteModel> getNotesByUserId(Long userId) {
        logger.info("Retrieve all notes");
        List<Note> userNotes = noteRepository.findByUserId(userId);
        logger.info("Successfully retrieved notes result - {}", getNoteModels(userNotes));

        return getNoteModels(userNotes);
    }


    @Transactional
    public List<NoteModel> searchNote(String text) {
        logger.info("Retrieve all notes");
        List<Note> userNotes = noteRepository.noteSearch(text);
        logger.info("Successfully retrieved notes result - {}", getNoteModels(userNotes));
        return getNoteModels(userNotes);
    }

    @Transactional
    public void deleteNote(long id) {
        noteRepository.deleteById(id);
    }

    @Transactional
    public NoteModel addNewNote(CreateNoteModel createNoteModel) {
        modelValidator.validate(createNoteModel);
        logger.info("Retrieve all notes");
        User user = userService.findById(createNoteModel.getUserId());
        Note note = noteRepository.save(createNoteModel.toEntity(user));
        return new NoteModel(note.getId(), note.getUser().getId(), note.getText());
    }

    @Transactional
    public void update(Long id, String text) {
        modelValidator.validate(text);
        logger.info("Retrieve all notes");
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("we dont have it"));
        note.setText(text);
        logger.info("Successfully retrieved notes result - {}", note);
        noteRepository.save(note);
    }
}
