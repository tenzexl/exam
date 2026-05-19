package kz.iitu.courses.service.impl;

import kz.iitu.courses.dto.lesson.BogdanovBogdanLessonCreateRequest;
import kz.iitu.courses.dto.lesson.BogdanovBogdanLessonResponse;
import kz.iitu.courses.dto.lesson.BogdanovBogdanLessonUpdateRequest;
import kz.iitu.courses.exception.BogdanovBogdanNotFoundException;
import kz.iitu.courses.mapper.BogdanovBogdanLessonMapper;
import kz.iitu.courses.model.BogdanovBogdanCourse;
import kz.iitu.courses.model.BogdanovBogdanLesson;
import kz.iitu.courses.repository.BogdanovBogdanCourseRepository;
import kz.iitu.courses.repository.BogdanovBogdanLessonRepository;
import kz.iitu.courses.service.BogdanovBogdanLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BogdanovBogdanLessonServiceImpl implements BogdanovBogdanLessonService {
    private final BogdanovBogdanLessonRepository lessonRepository;
    private final BogdanovBogdanCourseRepository courseRepository;

    @Override
    public BogdanovBogdanLessonResponse create(BogdanovBogdanLessonCreateRequest request) {
        BogdanovBogdanCourse course = courseRepository.findById(request.getCourseId())
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Course not found"));
        BogdanovBogdanLesson lesson = new BogdanovBogdanLesson();
        lesson.setTitle(request.getTitle());
        lesson.setContent(request.getContent());
        lesson.setCourse(course);
        return BogdanovBogdanLessonMapper.toResponse(lessonRepository.save(lesson));
    }

    @Override
    public BogdanovBogdanLessonResponse update(Long id, BogdanovBogdanLessonUpdateRequest request) {
        BogdanovBogdanLesson lesson = lessonRepository.findById(id)
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Lesson not found"));
        lesson.setTitle(request.getTitle());
        lesson.setContent(request.getContent());
        return BogdanovBogdanLessonMapper.toResponse(lessonRepository.save(lesson));
    }

    @Override
    public BogdanovBogdanLessonResponse getById(Long id) {
        BogdanovBogdanLesson lesson = lessonRepository.findById(id)
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Lesson not found"));
        return BogdanovBogdanLessonMapper.toResponse(lesson);
    }

    @Override
    public List<BogdanovBogdanLessonResponse> getAll() {
        return lessonRepository.findAll().stream().map(BogdanovBogdanLessonMapper::toResponse).toList();
    }

    @Override
    public void delete(Long id) {
        if (!lessonRepository.existsById(id)) {
            throw new BogdanovBogdanNotFoundException("Lesson not found");
        }
        lessonRepository.deleteById(id);
    }
}
