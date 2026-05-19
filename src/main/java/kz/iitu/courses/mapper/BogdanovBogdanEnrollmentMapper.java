package kz.iitu.courses.mapper;

import kz.iitu.courses.dto.enrollment.BogdanovBogdanEnrollmentResponse;
import kz.iitu.courses.model.BogdanovBogdanEnrollment;

public class BogdanovBogdanEnrollmentMapper {
    public static BogdanovBogdanEnrollmentResponse toResponse(BogdanovBogdanEnrollment enrollment) {
        BogdanovBogdanEnrollmentResponse response = new BogdanovBogdanEnrollmentResponse();
        response.setId(enrollment.getId());
        response.setStudentId(enrollment.getStudent().getId());
        response.setCourseId(enrollment.getCourse().getId());
        response.setStatus(enrollment.getStatus());
        response.setEnrolledAt(enrollment.getEnrolledAt());
        return response;
    }
}
