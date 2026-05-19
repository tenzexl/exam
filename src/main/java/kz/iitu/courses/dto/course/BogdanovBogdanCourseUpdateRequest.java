package kz.iitu.courses.dto.course;

import kz.iitu.courses.model.BogdanovBogdanCourseLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BogdanovBogdanCourseUpdateRequest {
    @NotBlank
    private String title;

    private String description;

    @NotNull
    private BogdanovBogdanCourseLevel level;

    @NotNull
    private Boolean active;

    @NotNull
    private Long instructorId;
}
