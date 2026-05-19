package kz.iitu.courses.mapper;

import kz.iitu.courses.dto.lesson.BogdanovBogdanLessonResponse;
import kz.iitu.courses.model.BogdanovBogdanLesson;

public class BogdanovBogdanLessonMapper {
    public static BogdanovBogdanLessonResponse toResponse(BogdanovBogdanLesson lesson) {
        BogdanovBogdanLessonResponse response = new BogdanovBogdanLessonResponse();
        response.setId(lesson.getId());
        response.setTitle(lesson.getTitle());
        response.setContent(lesson.getContent());
        response.setCourseId(lesson.getCourse().getId());
        return response;
    }
}
