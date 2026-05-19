package kz.iitu.courses.service;

import kz.iitu.courses.dto.lesson.BogdanovBogdanLessonCreateRequest;
import kz.iitu.courses.dto.lesson.BogdanovBogdanLessonResponse;
import kz.iitu.courses.dto.lesson.BogdanovBogdanLessonUpdateRequest;

import java.util.List;

public interface BogdanovBogdanLessonService {
    BogdanovBogdanLessonResponse create(BogdanovBogdanLessonCreateRequest request);
    BogdanovBogdanLessonResponse update(Long id, BogdanovBogdanLessonUpdateRequest request);
    BogdanovBogdanLessonResponse getById(Long id);
    List<BogdanovBogdanLessonResponse> getAll();
    void delete(Long id);
}
