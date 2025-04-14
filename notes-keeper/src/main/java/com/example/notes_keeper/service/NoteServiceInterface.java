package com.example.notes_keeper.service;

import com.example.notes_keeper.dto.NoteDTO;
import com.example.notes_keeper.models.Note;

import java.util.List;

public interface NoteServiceInterface {
    List<Note> getAllNotes();
    Note createNote(NoteDTO dto);
    void deleteNote(Long id);
    List<Note> searchByTitle(String keyword);
}
