package kz.iitu.courses.dto.enrollment;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BogdanovBogdanEnrollmentCreateRequest {
    @NotNull
    private Long studentId;

    @NotNull
    private Long courseId;
}
