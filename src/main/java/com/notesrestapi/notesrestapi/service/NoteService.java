package com.notesrestapi.notesrestapi.service;

import com.notesrestapi.notesrestapi.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    private List<Note> noteList;

    public NoteService() {
        noteList = new ArrayList<>();
    }

    public Note createNote(String Body) {
        Note newNote = new Note(noteList.size() + 1, Body);

        noteList.add(newNote);

        return newNote;
    }

    public Note findNote(int id) {
        if ( (id >= 0) && (id < (noteList.size() + 1)) ) {
            return noteList.get(id - 1);
        } else {
            return null;
        }
    }

    public List<Note> findAll(String query) {
        if (query == null) {
            return noteList;
        } else {
            List<Note> tempList = new ArrayList<>();

            for (Note note : noteList) {
                if (note.getBody().contains(query)) {
                    tempList.add(note);
                }
            }

            return tempList;
        }
    }
}
