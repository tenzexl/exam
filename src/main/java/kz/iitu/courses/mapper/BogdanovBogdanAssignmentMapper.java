package kz.iitu.courses.mapper;

import kz.iitu.courses.dto.assignment.BogdanovBogdanAssignmentResponse;
import kz.iitu.courses.model.BogdanovBogdanAssignment;

public class BogdanovBogdanAssignmentMapper {
    public static BogdanovBogdanAssignmentResponse toResponse(BogdanovBogdanAssignment assignment) {
        BogdanovBogdanAssignmentResponse response = new BogdanovBogdanAssignmentResponse();
        response.setId(assignment.getId());
        response.setCourseId(assignment.getCourse().getId());
        response.setTitle(assignment.getTitle());
        response.setDescription(assignment.getDescription());
        response.setDueDate(assignment.getDueDate());
        return response;
    }
}
