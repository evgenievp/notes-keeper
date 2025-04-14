package com.example.notes_keeper.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDateTime createdAt;



    @PrePersist
    public void setCreationTimeStamp() {
        this.createdAt = LocalDateTime.now();
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }



}
