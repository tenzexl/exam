package kz.iitu.courses.dto.file;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class BogdanovBogdanFileResponse {
    private Long id;
    private String originalName;
    private String contentType;
    private long size;
    private OffsetDateTime uploadedAt;
}
