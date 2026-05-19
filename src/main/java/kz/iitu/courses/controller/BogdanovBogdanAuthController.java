package kz.iitu.courses.controller;

import kz.iitu.courses.dto.auth.BogdanovBogdanAuthLoginRequest;
import kz.iitu.courses.dto.auth.BogdanovBogdanAuthRegisterRequest;
import kz.iitu.courses.dto.auth.BogdanovBogdanAuthResponse;
import kz.iitu.courses.service.BogdanovBogdanAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class BogdanovBogdanAuthController {
    private final BogdanovBogdanAuthService authService;

    @PostMapping("/register")
    public ResponseEntity<BogdanovBogdanAuthResponse> register(@Valid @RequestBody BogdanovBogdanAuthRegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<BogdanovBogdanAuthResponse> login(@Valid @RequestBody BogdanovBogdanAuthLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
