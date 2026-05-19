package kz.iitu.courses.mapper;

import kz.iitu.courses.dto.course.BogdanovBogdanCourseResponse;
import kz.iitu.courses.model.BogdanovBogdanCourse;

public class BogdanovBogdanCourseMapper {
    public static BogdanovBogdanCourseResponse toResponse(BogdanovBogdanCourse course) {
        BogdanovBogdanCourseResponse response = new BogdanovBogdanCourseResponse();
        response.setId(course.getId());
        response.setTitle(course.getTitle());
        response.setDescription(course.getDescription());
        response.setLevel(course.getLevel());
        response.setActive(course.isActive());
        response.setInstructorId(course.getInstructor().getId());
        response.setInstructorName(course.getInstructor().getFullName());
        return response;
    }
}
