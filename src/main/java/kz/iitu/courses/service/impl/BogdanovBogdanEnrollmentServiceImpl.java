package kz.iitu.courses.service.impl;

import kz.iitu.courses.dto.enrollment.BogdanovBogdanEnrollmentCreateRequest;
import kz.iitu.courses.dto.enrollment.BogdanovBogdanEnrollmentResponse;
import kz.iitu.courses.exception.BogdanovBogdanNotFoundException;
import kz.iitu.courses.mapper.BogdanovBogdanEnrollmentMapper;
import kz.iitu.courses.model.BogdanovBogdanCourse;
import kz.iitu.courses.model.BogdanovBogdanEnrollment;
import kz.iitu.courses.model.BogdanovBogdanEnrollmentStatus;
import kz.iitu.courses.model.BogdanovBogdanUser;
import kz.iitu.courses.repository.BogdanovBogdanCourseRepository;
import kz.iitu.courses.repository.BogdanovBogdanEnrollmentRepository;
import kz.iitu.courses.repository.BogdanovBogdanUserRepository;
import kz.iitu.courses.service.BogdanovBogdanAsyncTasksService;
import kz.iitu.courses.service.BogdanovBogdanEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BogdanovBogdanEnrollmentServiceImpl implements BogdanovBogdanEnrollmentService {
    private final BogdanovBogdanEnrollmentRepository enrollmentRepository;
    private final BogdanovBogdanUserRepository userRepository;
    private final BogdanovBogdanCourseRepository courseRepository;
    private final BogdanovBogdanAsyncTasksService asyncTasksService;

    @Override
    public BogdanovBogdanEnrollmentResponse create(BogdanovBogdanEnrollmentCreateRequest request) {
        BogdanovBogdanUser student = userRepository.findById(request.getStudentId())
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Student not found"));
        BogdanovBogdanCourse course = courseRepository.findById(request.getCourseId())
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Course not found"));

        BogdanovBogdanEnrollment enrollment = new BogdanovBogdanEnrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setStatus(BogdanovBogdanEnrollmentStatus.ACTIVE);
        enrollment.setEnrolledAt(OffsetDateTime.now());
        BogdanovBogdanEnrollment saved = enrollmentRepository.save(enrollment);

        asyncTasksService.sendEnrollmentNotification(saved.getId());
        asyncTasksService.generateCourseAnalytics(course.getId());

        return BogdanovBogdanEnrollmentMapper.toResponse(saved);
    }

    @Override
    public BogdanovBogdanEnrollmentResponse getById(Long id) {
        BogdanovBogdanEnrollment enrollment = enrollmentRepository.findById(id)
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Enrollment not found"));
        return BogdanovBogdanEnrollmentMapper.toResponse(enrollment);
    }

    @Override
    public List<BogdanovBogdanEnrollmentResponse> getAll() {
        return enrollmentRepository.findAll().stream().map(BogdanovBogdanEnrollmentMapper::toResponse).toList();
    }

    @Override
    public void delete(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new BogdanovBogdanNotFoundException("Enrollment not found");
        }
        enrollmentRepository.deleteById(id);
    }
}
