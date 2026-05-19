package kz.iitu.courses.service.impl;

import kz.iitu.courses.dto.course.BogdanovBogdanCourseCreateRequest;
import kz.iitu.courses.dto.course.BogdanovBogdanCourseResponse;
import kz.iitu.courses.dto.course.BogdanovBogdanCourseUpdateRequest;
import kz.iitu.courses.exception.BogdanovBogdanNotFoundException;
import kz.iitu.courses.mapper.BogdanovBogdanCourseMapper;
import kz.iitu.courses.model.BogdanovBogdanCourse;
import kz.iitu.courses.model.BogdanovBogdanCourseLevel;
import kz.iitu.courses.model.BogdanovBogdanUser;
import kz.iitu.courses.repository.BogdanovBogdanCourseRepository;
import kz.iitu.courses.repository.BogdanovBogdanUserRepository;
import kz.iitu.courses.service.BogdanovBogdanCourseService;
import kz.iitu.courses.util.BogdanovBogdanCourseSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BogdanovBogdanCourseServiceImpl implements BogdanovBogdanCourseService {
    private final BogdanovBogdanCourseRepository courseRepository;
    private final BogdanovBogdanUserRepository userRepository;

    @Override
    public BogdanovBogdanCourseResponse create(BogdanovBogdanCourseCreateRequest request) {
        BogdanovBogdanUser instructor = userRepository.findById(request.getInstructorId())
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Instructor not found"));

        BogdanovBogdanCourse course = new BogdanovBogdanCourse();
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setLevel(request.getLevel());
        course.setActive(request.getActive());
        course.setInstructor(instructor);

        return BogdanovBogdanCourseMapper.toResponse(courseRepository.save(course));
    }

    @Override
    public BogdanovBogdanCourseResponse update(Long id, BogdanovBogdanCourseUpdateRequest request) {
        BogdanovBogdanCourse course = courseRepository.findById(id)
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Course not found"));
        BogdanovBogdanUser instructor = userRepository.findById(request.getInstructorId())
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Instructor not found"));

        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setLevel(request.getLevel());
        course.setActive(request.getActive());
        course.setInstructor(instructor);

        return BogdanovBogdanCourseMapper.toResponse(courseRepository.save(course));
    }

    @Override
    public BogdanovBogdanCourseResponse getById(Long id) {
        BogdanovBogdanCourse course = courseRepository.findById(id)
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Course not found"));
        return BogdanovBogdanCourseMapper.toResponse(course);
    }

    @Override
    public Page<BogdanovBogdanCourseResponse> search(String query, BogdanovBogdanCourseLevel level, Boolean active, Long instructorId, Pageable pageable) {
        return courseRepository.findAll(
            BogdanovBogdanCourseSpecifications.withFilters(query, level, active, instructorId), pageable)
            .map(BogdanovBogdanCourseMapper::toResponse);
    }

    @Override
    public void delete(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new BogdanovBogdanNotFoundException("Course not found");
        }
        courseRepository.deleteById(id);
    }
}
