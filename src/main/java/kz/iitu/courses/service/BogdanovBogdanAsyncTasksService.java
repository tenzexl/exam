package kz.iitu.courses.service;

import java.util.concurrent.CompletableFuture;

public interface BogdanovBogdanAsyncTasksService {
    CompletableFuture<Void> sendEnrollmentNotification(Long enrollmentId);
    CompletableFuture<Void> generateCourseAnalytics(Long courseId);
    CompletableFuture<Void> plagiarismCheck(Long submissionId);
}
