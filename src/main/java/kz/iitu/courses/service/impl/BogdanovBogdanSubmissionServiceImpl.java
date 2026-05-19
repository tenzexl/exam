package kz.iitu.courses.service.impl;

import kz.iitu.courses.dto.submission.BogdanovBogdanSubmissionCreateRequest;
import kz.iitu.courses.dto.submission.BogdanovBogdanSubmissionResponse;
import kz.iitu.courses.dto.submission.BogdanovBogdanSubmissionUpdateRequest;
import kz.iitu.courses.exception.BogdanovBogdanNotFoundException;
import kz.iitu.courses.mapper.BogdanovBogdanSubmissionMapper;
import kz.iitu.courses.model.*;
import kz.iitu.courses.repository.BogdanovBogdanAssignmentRepository;
import kz.iitu.courses.repository.BogdanovBogdanFileAssetRepository;
import kz.iitu.courses.repository.BogdanovBogdanSubmissionRepository;
import kz.iitu.courses.repository.BogdanovBogdanUserRepository;
import kz.iitu.courses.service.BogdanovBogdanAsyncTasksService;
import kz.iitu.courses.service.BogdanovBogdanSubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BogdanovBogdanSubmissionServiceImpl implements BogdanovBogdanSubmissionService {
    private final BogdanovBogdanSubmissionRepository submissionRepository;
    private final BogdanovBogdanAssignmentRepository assignmentRepository;
    private final BogdanovBogdanUserRepository userRepository;
    private final BogdanovBogdanFileAssetRepository fileAssetRepository;
    private final BogdanovBogdanAsyncTasksService asyncTasksService;

    @Override
    public BogdanovBogdanSubmissionResponse create(BogdanovBogdanSubmissionCreateRequest request) {
        BogdanovBogdanAssignment assignment = assignmentRepository.findById(request.getAssignmentId())
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Assignment not found"));
        BogdanovBogdanUser student = userRepository.findById(request.getStudentId())
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Student not found"));

        BogdanovBogdanSubmission submission = new BogdanovBogdanSubmission();
        submission.setAssignment(assignment);
        submission.setStudent(student);
        submission.setStatus(BogdanovBogdanSubmissionStatus.SUBMITTED);
        submission.setSubmittedAt(OffsetDateTime.now());

        if (request.getFileAssetId() != null) {
            BogdanovBogdanFileAsset fileAsset = fileAssetRepository.findById(request.getFileAssetId())
                .orElseThrow(() -> new BogdanovBogdanNotFoundException("File not found"));
            submission.setFileAsset(fileAsset);
        }

        BogdanovBogdanSubmission saved = submissionRepository.save(submission);
        asyncTasksService.plagiarismCheck(saved.getId());
        return BogdanovBogdanSubmissionMapper.toResponse(saved);
    }

    @Override
    public BogdanovBogdanSubmissionResponse update(Long id, BogdanovBogdanSubmissionUpdateRequest request) {
        BogdanovBogdanSubmission submission = submissionRepository.findById(id)
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Submission not found"));
        submission.setStatus(request.getStatus());
        if (request.getFileAssetId() != null) {
            BogdanovBogdanFileAsset fileAsset = fileAssetRepository.findById(request.getFileAssetId())
                .orElseThrow(() -> new BogdanovBogdanNotFoundException("File not found"));
            submission.setFileAsset(fileAsset);
        }
        return BogdanovBogdanSubmissionMapper.toResponse(submissionRepository.save(submission));
    }

    @Override
    public BogdanovBogdanSubmissionResponse getById(Long id) {
        BogdanovBogdanSubmission submission = submissionRepository.findById(id)
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Submission not found"));
        return BogdanovBogdanSubmissionMapper.toResponse(submission);
    }

    @Override
    public List<BogdanovBogdanSubmissionResponse> getAll() {
        return submissionRepository.findAll().stream().map(BogdanovBogdanSubmissionMapper::toResponse).toList();
    }

    @Override
    public void delete(Long id) {
        if (!submissionRepository.existsById(id)) {
            throw new BogdanovBogdanNotFoundException("Submission not found");
        }
        submissionRepository.deleteById(id);
    }
}
