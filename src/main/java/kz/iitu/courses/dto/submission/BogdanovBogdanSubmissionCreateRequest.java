package kz.iitu.courses.dto.submission;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BogdanovBogdanSubmissionCreateRequest {
    @NotNull
    private Long assignmentId;

    @NotNull
    private Long studentId;

    private Long fileAssetId;
}
