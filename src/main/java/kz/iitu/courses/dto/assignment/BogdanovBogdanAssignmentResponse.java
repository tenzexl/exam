package kz.iitu.courses.dto.assignment;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class BogdanovBogdanAssignmentResponse {
    private Long id;
    private Long courseId;
    private String title;
    private String description;
    private OffsetDateTime dueDate;
}
