package kz.iitu.courses.service.impl;

import kz.iitu.courses.dto.assignment.BogdanovBogdanAssignmentCreateRequest;
import kz.iitu.courses.dto.assignment.BogdanovBogdanAssignmentResponse;
import kz.iitu.courses.dto.assignment.BogdanovBogdanAssignmentUpdateRequest;
import kz.iitu.courses.exception.BogdanovBogdanNotFoundException;
import kz.iitu.courses.mapper.BogdanovBogdanAssignmentMapper;
import kz.iitu.courses.model.BogdanovBogdanAssignment;
import kz.iitu.courses.model.BogdanovBogdanCourse;
import kz.iitu.courses.repository.BogdanovBogdanAssignmentRepository;
import kz.iitu.courses.repository.BogdanovBogdanCourseRepository;
import kz.iitu.courses.service.BogdanovBogdanAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BogdanovBogdanAssignmentServiceImpl implements BogdanovBogdanAssignmentService {
    private final BogdanovBogdanAssignmentRepository assignmentRepository;
    private final BogdanovBogdanCourseRepository courseRepository;

    @Override
    public BogdanovBogdanAssignmentResponse create(BogdanovBogdanAssignmentCreateRequest request) {
        BogdanovBogdanCourse course = courseRepository.findById(request.getCourseId())
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Course not found"));

        BogdanovBogdanAssignment assignment = new BogdanovBogdanAssignment();
        assignment.setCourse(course);
        assignment.setTitle(request.getTitle());
        assignment.setDescription(request.getDescription());
        assignment.setDueDate(request.getDueDate());
        return BogdanovBogdanAssignmentMapper.toResponse(assignmentRepository.save(assignment));
    }

    @Override
    public BogdanovBogdanAssignmentResponse update(Long id, BogdanovBogdanAssignmentUpdateRequest request) {
        BogdanovBogdanAssignment assignment = assignmentRepository.findById(id)
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Assignment not found"));
        assignment.setTitle(request.getTitle());
        assignment.setDescription(request.getDescription());
        assignment.setDueDate(request.getDueDate());
        return BogdanovBogdanAssignmentMapper.toResponse(assignmentRepository.save(assignment));
    }

    @Override
    public BogdanovBogdanAssignmentResponse getById(Long id) {
        BogdanovBogdanAssignment assignment = assignmentRepository.findById(id)
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("Assignment not found"));
        return BogdanovBogdanAssignmentMapper.toResponse(assignment);
    }

    @Override
    public List<BogdanovBogdanAssignmentResponse> getAll() {
        return assignmentRepository.findAll().stream().map(BogdanovBogdanAssignmentMapper::toResponse).toList();
    }

    @Override
    public void delete(Long id) {
        if (!assignmentRepository.existsById(id)) {
            throw new BogdanovBogdanNotFoundException("Assignment not found");
        }
        assignmentRepository.deleteById(id);
    }
}
