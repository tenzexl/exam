package kz.iitu.courses.dto.submission;

import kz.iitu.courses.model.BogdanovBogdanSubmissionStatus;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class BogdanovBogdanSubmissionResponse {
    private Long id;
    private Long assignmentId;
    private Long studentId;
    private Long fileAssetId;
    private BogdanovBogdanSubmissionStatus status;
    private OffsetDateTime submittedAt;
}
