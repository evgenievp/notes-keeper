package com.example.notes_keeper.service;

import com.example.notes_keeper.dto.NoteDTO;
import com.example.notes_keeper.models.Note;
import com.example.notes_keeper.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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


    public Note addNote(Note note) {
        return repository.save(note);
    }

    public List<Note> searchByTitle(String keyword) {
        return repository.findByTitleContaining(keyword);
    }

    private NoteDTO mapToDTO(Note note) {
        return new NoteDTO(note.getId(), note.getTitle(), note.getContent());
    }


}
