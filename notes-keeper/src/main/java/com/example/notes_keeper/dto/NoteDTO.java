package com.example.notes_keeper.dto;

public class NoteDTO {

    private String title;
    private String content;
    private Long id;

    public NoteDTO() {}

    public NoteDTO(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
