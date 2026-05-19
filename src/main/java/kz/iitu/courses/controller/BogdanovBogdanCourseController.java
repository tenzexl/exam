package kz.iitu.courses.controller;

import kz.iitu.courses.dto.course.BogdanovBogdanCourseCreateRequest;
import kz.iitu.courses.dto.course.BogdanovBogdanCourseResponse;
import kz.iitu.courses.dto.course.BogdanovBogdanCourseUpdateRequest;
import kz.iitu.courses.model.BogdanovBogdanCourseLevel;
import kz.iitu.courses.service.BogdanovBogdanCourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class BogdanovBogdanCourseController {
    private final BogdanovBogdanCourseService courseService;

    @PostMapping
    public ResponseEntity<BogdanovBogdanCourseResponse> create(@Valid @RequestBody BogdanovBogdanCourseCreateRequest request) {
        return ResponseEntity.ok(courseService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BogdanovBogdanCourseResponse> update(@PathVariable Long id,
                                                               @Valid @RequestBody BogdanovBogdanCourseUpdateRequest request) {
        return ResponseEntity.ok(courseService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BogdanovBogdanCourseResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getById(id));
    }

    @GetMapping
    public ResponseEntity<Page<BogdanovBogdanCourseResponse>> search(
        @RequestParam(required = false) String q,
        @RequestParam(required = false) BogdanovBogdanCourseLevel level,
        @RequestParam(required = false) Boolean active,
        @RequestParam(required = false) Long instructorId,
        Pageable pageable
    ) {
        return ResponseEntity.ok(courseService.search(q, level, active, instructorId, pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
