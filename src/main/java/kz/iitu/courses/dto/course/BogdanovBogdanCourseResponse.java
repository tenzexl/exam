package kz.iitu.courses.dto.course;

import kz.iitu.courses.model.BogdanovBogdanCourseLevel;
import lombok.Data;

@Data
public class BogdanovBogdanCourseResponse {
    private Long id;
    private String title;
    private String description;
    private BogdanovBogdanCourseLevel level;
    private boolean active;
    private Long instructorId;
    private String instructorName;
}
