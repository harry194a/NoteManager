package com.hb.platform.notemanager.service.note;

import com.hb.platform.notemanager.domain.common.PageModel;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Add totalCount into all page responses.
//return page instead all lists
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

    //clean code, add page model instead of the parameters, add validations in that model
    @Transactional(readOnly = true)
    public PageModel getNotes(PageRequest pr) {
        logger.info("Retrieve all notes");
        Page<Note> notesPage = noteRepository.findAll(pr);
        List<NoteModel> noteModels = mapToNoteModels(notesPage.get().collect(Collectors.toList()));
        logger.info("Successfully retrieved notes result - {}", noteModels);
        return new PageModel(noteModels, notesPage.getTotalElements());
    }

    @Transactional(readOnly = true)
    public List<NoteModel> getNotesByUserId(Long userId) {
        logger.info("Retrieve all notes");
        List<Note> userNotes = noteRepository.findByUserId(userId);
        logger.info("Successfully retrieved notes result - {}", mapToNoteModels(userNotes));
        return mapToNoteModels(userNotes);
    }
    @Transactional(readOnly = true)
    public List<NoteModel> getNotesByUserIdWithPagination(Long userId, Long page, Long limit) {
        logger.info("Retrieve all notes");
        Long offset = page * limit;
        List<Note> userNotes = noteRepository.findByUserIdAndPagination(userId,offset,limit);
        logger.info("Successfully retrieved notes result - {}", mapToNoteModels(userNotes));
        return mapToNoteModels(userNotes);
    }
    @Transactional(readOnly = true)
    public List<NoteModel> searchNote(String text) {
        logger.info("Retrieve all notes");
        List<Note> userNotes = noteRepository.noteSearch(text);
        logger.info("Successfully retrieved notes result - {}", mapToNoteModels(userNotes));
        return mapToNoteModels(userNotes);
    }

    @Transactional(readOnly = true)
    public List<NoteModel> searchNoteAndUserId(Long id, String text,Long page, Long size) {
        logger.info("Retrieve all notes");
        Long offset = page * size;
        List<Note> userNotesById = noteRepository.noteSearchId(id, text,size,offset);
        logger.info("Successfully retrieved notes result - {}", mapToNoteModels(userNotesById));
        return mapToNoteModels(userNotesById);
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
        return mapToNoteModel(note);
    }

    @Transactional
    public NoteModel update(Long id, String text) {
        modelValidator.validate(text);
        logger.info("Retrieve all notes");
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("we dont have it"));
        note.setText(text);
        logger.info("Successfully retrieved notes result - {}", note);
        noteRepository.save(note);
        return mapToNoteModel(note);
    }

    private List<NoteModel> mapToNoteModels(List<Note> userNotes) {
        List<NoteModel> noteModels = new ArrayList<>();
        for (Note note : userNotes) {
            noteModels.add(mapToNoteModel(note));
        }
        logger.info("Successfully retrieved notes result - {}", noteModels);
        return noteModels;
    }

    private NoteModel mapToNoteModel(Note note) {
        return new NoteModel(
                note.getId(), note.getUser().getId(),
                note.getText(), note.getCreatedTime());
    }
}
