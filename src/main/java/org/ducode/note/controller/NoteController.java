package org.ducode.note.controller;

import org.ducode.note.dto.NoteDto;
import org.ducode.note.model.Note;
import org.ducode.note.service.NoteService;
import org.ducode.note.transformer.NoteMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NoteController {

    private final NoteMapper noteMapper;
    private final NoteService noteService;

    public NoteController(NoteMapper noteMapper, NoteService noteService) {
        this.noteMapper = noteMapper;
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public List<NoteDto> getAll() {
        List<Note> notes = noteService.getAll();
        return notes.stream()
                .map(noteMapper::noteToNoteDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/notes")
    public ResponseEntity<NoteDto> createNote(@RequestBody NoteDto dto) {
        Note newNote = noteMapper.noteDtoToNote(dto);
        Note entity = noteService.create(newNote);
        NoteDto entityDto = noteMapper.noteToNoteDto(entity);
        return ResponseEntity
                .created(URI.create("/notes/" + entityDto.getId()))
                .body(entityDto);
    }

}
