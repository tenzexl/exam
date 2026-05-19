package kz.iitu.courses.service;

import kz.iitu.courses.dto.course.BogdanovBogdanCourseCreateRequest;
import kz.iitu.courses.dto.course.BogdanovBogdanCourseResponse;
import kz.iitu.courses.dto.course.BogdanovBogdanCourseUpdateRequest;
import kz.iitu.courses.model.BogdanovBogdanCourseLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BogdanovBogdanCourseService {
    BogdanovBogdanCourseResponse create(BogdanovBogdanCourseCreateRequest request);
    BogdanovBogdanCourseResponse update(Long id, BogdanovBogdanCourseUpdateRequest request);
    BogdanovBogdanCourseResponse getById(Long id);
    Page<BogdanovBogdanCourseResponse> search(String query, BogdanovBogdanCourseLevel level, Boolean active, Long instructorId, Pageable pageable);
    void delete(Long id);
}
