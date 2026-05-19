package kz.iitu.courses.dto.lesson;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BogdanovBogdanLessonUpdateRequest {
    @NotBlank
    private String title;

    private String content;
}
