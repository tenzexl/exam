package kz.iitu.courses.dto.lesson;

import lombok.Data;

@Data
public class BogdanovBogdanLessonResponse {
    private Long id;
    private String title;
    private String content;
    private Long courseId;
}
