package kz.iitu.courses.service;

import kz.iitu.courses.dto.submission.BogdanovBogdanSubmissionCreateRequest;
import kz.iitu.courses.dto.submission.BogdanovBogdanSubmissionResponse;
import kz.iitu.courses.dto.submission.BogdanovBogdanSubmissionUpdateRequest;

import java.util.List;

public interface BogdanovBogdanSubmissionService {
    BogdanovBogdanSubmissionResponse create(BogdanovBogdanSubmissionCreateRequest request);
    BogdanovBogdanSubmissionResponse update(Long id, BogdanovBogdanSubmissionUpdateRequest request);
    BogdanovBogdanSubmissionResponse getById(Long id);
    List<BogdanovBogdanSubmissionResponse> getAll();
    void delete(Long id);
}
