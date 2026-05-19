package kz.iitu.courses.mapper;

import kz.iitu.courses.dto.submission.BogdanovBogdanSubmissionResponse;
import kz.iitu.courses.model.BogdanovBogdanSubmission;

public class BogdanovBogdanSubmissionMapper {
    public static BogdanovBogdanSubmissionResponse toResponse(BogdanovBogdanSubmission submission) {
        BogdanovBogdanSubmissionResponse response = new BogdanovBogdanSubmissionResponse();
        response.setId(submission.getId());
        response.setAssignmentId(submission.getAssignment().getId());
        response.setStudentId(submission.getStudent().getId());
        response.setFileAssetId(submission.getFileAsset() == null ? null : submission.getFileAsset().getId());
        response.setStatus(submission.getStatus());
        response.setSubmittedAt(submission.getSubmittedAt());
        return response;
    }
}
