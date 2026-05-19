package kz.iitu.courses.dto.lesson;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BogdanovBogdanLessonCreateRequest {
    @NotBlank
    private String title;

    private String content;

    @NotNull
    private Long courseId;
}
