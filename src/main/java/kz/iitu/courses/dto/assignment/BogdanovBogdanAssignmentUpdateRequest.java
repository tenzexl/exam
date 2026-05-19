package kz.iitu.courses.dto.assignment;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class BogdanovBogdanAssignmentUpdateRequest {
    @NotBlank
    private String title;

    private String description;

    private OffsetDateTime dueDate;
}
