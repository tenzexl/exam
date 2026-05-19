package kz.iitu.courses.controller;

import kz.iitu.courses.dto.assignment.BogdanovBogdanAssignmentCreateRequest;
import kz.iitu.courses.dto.assignment.BogdanovBogdanAssignmentResponse;
import kz.iitu.courses.dto.assignment.BogdanovBogdanAssignmentUpdateRequest;
import kz.iitu.courses.service.BogdanovBogdanAssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class BogdanovBogdanAssignmentController {
    private final BogdanovBogdanAssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<BogdanovBogdanAssignmentResponse> create(@Valid @RequestBody BogdanovBogdanAssignmentCreateRequest request) {
        return ResponseEntity.ok(assignmentService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BogdanovBogdanAssignmentResponse> update(@PathVariable Long id,
                                                                   @Valid @RequestBody BogdanovBogdanAssignmentUpdateRequest request) {
        return ResponseEntity.ok(assignmentService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BogdanovBogdanAssignmentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(assignmentService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BogdanovBogdanAssignmentResponse>> getAll() {
        return ResponseEntity.ok(assignmentService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        assignmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
