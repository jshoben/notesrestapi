package com.notesrestapi.notesrestapi.controller;

import com.notesrestapi.notesrestapi.model.Note;
import com.notesrestapi.notesrestapi.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    NoteService noteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Note findNote(@PathVariable("id") int id) {
        return noteService.findNote(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Note> findAll(@RequestParam(value = "query", required = false) String query) {
        return noteService.findAll(query);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Note create(@RequestBody Map<String, String> newNote) {
        String body = newNote.get("body");

        return noteService.createNote(body);
    }
}
