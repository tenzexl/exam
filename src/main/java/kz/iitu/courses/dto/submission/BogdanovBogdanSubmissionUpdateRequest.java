package kz.iitu.courses.dto.submission;

import kz.iitu.courses.model.BogdanovBogdanSubmissionStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BogdanovBogdanSubmissionUpdateRequest {
    @NotNull
    private BogdanovBogdanSubmissionStatus status;

    private Long fileAssetId;
}
