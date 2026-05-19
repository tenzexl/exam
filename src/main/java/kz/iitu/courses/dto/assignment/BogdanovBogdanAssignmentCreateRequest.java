package kz.iitu.courses.dto.assignment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class BogdanovBogdanAssignmentCreateRequest {
    @NotNull
    private Long courseId;

    @NotBlank
    private String title;

    private String description;

    private OffsetDateTime dueDate;
}
