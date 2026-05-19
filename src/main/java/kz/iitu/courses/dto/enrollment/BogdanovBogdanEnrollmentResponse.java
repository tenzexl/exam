package kz.iitu.courses.dto.enrollment;

import kz.iitu.courses.model.BogdanovBogdanEnrollmentStatus;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class BogdanovBogdanEnrollmentResponse {
    private Long id;
    private Long studentId;
    private Long courseId;
    private BogdanovBogdanEnrollmentStatus status;
    private OffsetDateTime enrolledAt;
}
