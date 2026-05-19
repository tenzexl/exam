package kz.iitu.courses.service.impl;

import kz.iitu.courses.service.BogdanovBogdanAsyncTasksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class BogdanovBogdanAsyncTasksServiceImpl implements BogdanovBogdanAsyncTasksService {
    @Override
    @Async
    public CompletableFuture<Void> sendEnrollmentNotification(Long enrollmentId) {
        log.info("Sending enrollment notification for enrollmentId={}", enrollmentId);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    @Async
    public CompletableFuture<Void> generateCourseAnalytics(Long courseId) {
        log.info("Generating course analytics for courseId={}", courseId);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    @Async
    public CompletableFuture<Void> plagiarismCheck(Long submissionId) {
        log.info("Running plagiarism check for submissionId={}", submissionId);
        return CompletableFuture.completedFuture(null);
    }
}
