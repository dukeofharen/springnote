package org.ducode.note.transformer;

import org.ducode.note.dto.NoteDto;
import org.ducode.note.model.Note;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NoteMapper {

    NoteDto noteToNoteDto(Note note);

    Note noteDtoToNote(NoteDto dto);

}
