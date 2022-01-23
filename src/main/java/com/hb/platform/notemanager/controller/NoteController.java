package com.hb.platform.notemanager.controller;

import com.hb.platform.notemanager.domain.common.PageModel;
import com.hb.platform.notemanager.domain.note.CreateNoteModel;
import com.hb.platform.notemanager.domain.note.NoteModel;
import com.hb.platform.notemanager.service.note.NoteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO add missing logs in controller
@RestController
@RequestMapping(path = "api/notes")
@Api("NoteController")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public PageModel getNotes(
            @RequestParam("page") Long page,
            @RequestParam("size") Integer size) {
        return noteService.getNotes(PageRequest.of(page.intValue(), size));
    }

    @GetMapping("findByIdPage")
    public List<NoteModel> getNotesByIdPage(
            @RequestParam("id") Long id,
            @RequestParam("page") Long page,
            @RequestParam("size") Long size) {
        return noteService.getNotesByUserIdWithPagination(id, page, size);
    }

    @GetMapping("users/{userId}")
    public List<NoteModel> getNotes(@PathVariable("userId") Long useId) {
        return noteService.getNotesByUserId(useId);
    }


    @GetMapping("searchById/{userId}/{search}")
    public List<NoteModel> searchById(@PathVariable("userId") Long userId,
                                      @PathVariable("search") String search,
                                      @RequestParam("page") Long page,
                                      @RequestParam("size")Long size) {

        return noteService.searchNoteAndUserId(userId, search ,page,size );
    }

    @GetMapping("search/{search}")
    public List<NoteModel> search(
            @RequestHeader("Authorization") String token,
            @PathVariable("search") String search) {
        return noteService.searchNote(search);
    }


    @PostMapping
    public NoteModel createNote(@RequestBody CreateNoteModel createNoteModel) {
        return noteService.addNewNote(createNoteModel);
    }

    @PutMapping
    public NoteModel update(@RequestBody String text, long id) {
        return noteService.update(id, text);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        noteService.deleteNote(id);
    }
}
