package kz.iitu.courses.service;

import kz.iitu.courses.dto.enrollment.BogdanovBogdanEnrollmentCreateRequest;
import kz.iitu.courses.dto.enrollment.BogdanovBogdanEnrollmentResponse;

import java.util.List;

public interface BogdanovBogdanEnrollmentService {
    BogdanovBogdanEnrollmentResponse create(BogdanovBogdanEnrollmentCreateRequest request);
    BogdanovBogdanEnrollmentResponse getById(Long id);
    List<BogdanovBogdanEnrollmentResponse> getAll();
    void delete(Long id);
}
