package kz.iitu.courses.controller;

import kz.iitu.courses.dto.enrollment.BogdanovBogdanEnrollmentCreateRequest;
import kz.iitu.courses.dto.enrollment.BogdanovBogdanEnrollmentResponse;
import kz.iitu.courses.service.BogdanovBogdanEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class BogdanovBogdanEnrollmentController {
    private final BogdanovBogdanEnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<BogdanovBogdanEnrollmentResponse> create(@Valid @RequestBody BogdanovBogdanEnrollmentCreateRequest request) {
        return ResponseEntity.ok(enrollmentService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BogdanovBogdanEnrollmentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BogdanovBogdanEnrollmentResponse>> getAll() {
        return ResponseEntity.ok(enrollmentService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
