package com.example.notes_keeper.dto;

public class NoteDTO {

    private String title;
    private String content;

    public NoteDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }



}
