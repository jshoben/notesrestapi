package com.notesrestapi.notesrestapi.model;

public class Note {

    private int id;
    private String body;

    public Note(int Id, String Body) {
        this.id = Id;
        this.body = Body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
