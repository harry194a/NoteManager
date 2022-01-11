package com.hb.platform.notemanager.controller;

import com.hb.platform.notemanager.domain.note.CreateNoteModel;
import com.hb.platform.notemanager.domain.note.NoteModel;
import com.hb.platform.notemanager.service.note.NoteService;
import com.hb.platform.notemanager.service.user.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/notes")
@Api("NoteController")
public class NoteController {

    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

    private final NoteService noteService;
    private final UserService userService;


    @Autowired
    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping
    @Transactional
    public List<NoteModel> getNotes() {
        return noteService.getNotes();
    }

    @GetMapping("users/{userId}")
    @Transactional
    public List<NoteModel> getNotes(@PathVariable("userId") Long useId) {
        return noteService.getNotesByUserId(useId);
    }

    @GetMapping("users/search/{search}")
    @Transactional
    public List<NoteModel> search(@PathVariable("search") String search) {
        return noteService.searchNote(search);
    }


    @PostMapping
    public NoteModel createNote(@RequestBody CreateNoteModel createNoteModel) {
        //        logger.info("note user name is - {}", note.getUser().getFistName());
        return noteService.addNewNote(createNoteModel);
    }

    @PutMapping
    public void update(@RequestBody String text, long id) {
        noteService.update(id, text);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        noteService.deleteNote(id);
    }
}
