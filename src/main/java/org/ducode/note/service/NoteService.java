package org.ducode.note.service;

import lombok.extern.java.Log;
import org.ducode.note.model.Note;
import org.ducode.note.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@Log
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAll() {
        log.info("Retrieving all notes.");
        return StreamSupport.stream(noteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Note create(Note note) {
        log.info("Persisting Note with title " + note.getTitle());
        return noteRepository.save(note);
    }
}
