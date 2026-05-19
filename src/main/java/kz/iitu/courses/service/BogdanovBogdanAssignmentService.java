package kz.iitu.courses.service;

import kz.iitu.courses.dto.assignment.BogdanovBogdanAssignmentCreateRequest;
import kz.iitu.courses.dto.assignment.BogdanovBogdanAssignmentResponse;
import kz.iitu.courses.dto.assignment.BogdanovBogdanAssignmentUpdateRequest;

import java.util.List;

public interface BogdanovBogdanAssignmentService {
    BogdanovBogdanAssignmentResponse create(BogdanovBogdanAssignmentCreateRequest request);
    BogdanovBogdanAssignmentResponse update(Long id, BogdanovBogdanAssignmentUpdateRequest request);
    BogdanovBogdanAssignmentResponse getById(Long id);
    List<BogdanovBogdanAssignmentResponse> getAll();
    void delete(Long id);
}
