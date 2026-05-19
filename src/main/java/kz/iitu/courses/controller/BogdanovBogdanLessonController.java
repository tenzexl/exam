package kz.iitu.courses.controller;

import kz.iitu.courses.dto.lesson.BogdanovBogdanLessonCreateRequest;
import kz.iitu.courses.dto.lesson.BogdanovBogdanLessonResponse;
import kz.iitu.courses.dto.lesson.BogdanovBogdanLessonUpdateRequest;
import kz.iitu.courses.service.BogdanovBogdanLessonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class BogdanovBogdanLessonController {
    private final BogdanovBogdanLessonService lessonService;

    @PostMapping
    public ResponseEntity<BogdanovBogdanLessonResponse> create(@Valid @RequestBody BogdanovBogdanLessonCreateRequest request) {
        return ResponseEntity.ok(lessonService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BogdanovBogdanLessonResponse> update(@PathVariable Long id,
                                                               @Valid @RequestBody BogdanovBogdanLessonUpdateRequest request) {
        return ResponseEntity.ok(lessonService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BogdanovBogdanLessonResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BogdanovBogdanLessonResponse>> getAll() {
        return ResponseEntity.ok(lessonService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lessonService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
