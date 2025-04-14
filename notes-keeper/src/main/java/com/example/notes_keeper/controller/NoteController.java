package com.example.notes_keeper.controller;

import com.example.notes_keeper.dto.NoteDTO;
import com.example.notes_keeper.models.Note;
import com.example.notes_keeper.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping
    public List<NoteDTO> getAllNotes() {
        return service.getAllNotes()
                .stream()
                .map(note -> new NoteDTO(note.getId(), note.getTitle(), note.getContent()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public Note createNote(@RequestBody NoteDTO dto) {
        return service.createNote(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        service.deleteNote(id);
    }

    @GetMapping("/search")
    public List<Note> searchNotes(@RequestParam String keyword) {
        return service.searchByTitle(keyword);
    }
}
