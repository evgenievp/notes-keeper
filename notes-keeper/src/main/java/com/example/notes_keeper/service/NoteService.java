package com.example.notes_keeper.service;

import com.example.notes_keeper.dto.NoteDTO;
import com.example.notes_keeper.models.Note;
import com.example.notes_keeper.repository.NoteRepository;

import java.util.List;

public class NoteService {

    private NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    public Note createNote(NoteDTO dto) {
        Note note = new Note();
        note.setTitle(dto.getTitle());
        note.setContent(dto.getContent());
        return repository.save(note);
    }

    public void deleteNote(Long id) {
        repository.deleteById(id);
    }




}
