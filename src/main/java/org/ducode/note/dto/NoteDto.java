package org.ducode.note.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {
    private long id;
    private OffsetDateTime created;
    private OffsetDateTime changed;
    private String title;
    private String content;
    private String secretCode;
}
