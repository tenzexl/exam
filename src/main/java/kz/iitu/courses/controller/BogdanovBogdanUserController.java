package kz.iitu.courses.controller;

import kz.iitu.courses.dto.user.BogdanovBogdanUserCreateRequest;
import kz.iitu.courses.dto.user.BogdanovBogdanUserResponse;
import kz.iitu.courses.service.BogdanovBogdanUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class BogdanovBogdanUserController {
    private final BogdanovBogdanUserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<BogdanovBogdanUserResponse> create(@Valid @RequestBody BogdanovBogdanUserCreateRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BogdanovBogdanUserResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<BogdanovBogdanUserResponse>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
