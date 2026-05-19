package kz.iitu.courses.controller;

import kz.iitu.courses.dto.submission.BogdanovBogdanSubmissionCreateRequest;
import kz.iitu.courses.dto.submission.BogdanovBogdanSubmissionResponse;
import kz.iitu.courses.dto.submission.BogdanovBogdanSubmissionUpdateRequest;
import kz.iitu.courses.service.BogdanovBogdanSubmissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
@RequiredArgsConstructor
public class BogdanovBogdanSubmissionController {
    private final BogdanovBogdanSubmissionService submissionService;

    @PostMapping
    public ResponseEntity<BogdanovBogdanSubmissionResponse> create(@Valid @RequestBody BogdanovBogdanSubmissionCreateRequest request) {
        return ResponseEntity.ok(submissionService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BogdanovBogdanSubmissionResponse> update(@PathVariable Long id,
                                                                   @Valid @RequestBody BogdanovBogdanSubmissionUpdateRequest request) {
        return ResponseEntity.ok(submissionService.update(id, request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BogdanovBogdanSubmissionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(submissionService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BogdanovBogdanSubmissionResponse>> getAll() {
        return ResponseEntity.ok(submissionService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        submissionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
