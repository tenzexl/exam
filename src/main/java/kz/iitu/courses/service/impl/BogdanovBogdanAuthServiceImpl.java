package kz.iitu.courses.service.impl;

import kz.iitu.courses.dto.auth.BogdanovBogdanAuthLoginRequest;
import kz.iitu.courses.dto.auth.BogdanovBogdanAuthRegisterRequest;
import kz.iitu.courses.dto.auth.BogdanovBogdanAuthResponse;
import kz.iitu.courses.exception.BogdanovBogdanBadRequestException;
import kz.iitu.courses.mapper.BogdanovBogdanUserMapper;
import kz.iitu.courses.model.BogdanovBogdanRole;
import kz.iitu.courses.model.BogdanovBogdanUser;
import kz.iitu.courses.repository.BogdanovBogdanUserRepository;
import kz.iitu.courses.security.BogdanovBogdanJwtService;
import kz.iitu.courses.service.BogdanovBogdanAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BogdanovBogdanAuthServiceImpl implements BogdanovBogdanAuthService {
    private final BogdanovBogdanUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final BogdanovBogdanJwtService jwtService;

    @Override
    public BogdanovBogdanAuthResponse register(BogdanovBogdanAuthRegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BogdanovBogdanBadRequestException("Email already exists");
        }
        BogdanovBogdanUser user = new BogdanovBogdanUser();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFullName(request.getFullName());
        user.setRole(request.getRole() == null ? BogdanovBogdanRole.STUDENT : request.getRole());
        BogdanovBogdanUser saved = userRepository.save(user);

        UserDetails principal = org.springframework.security.core.userdetails.User
            .withUsername(saved.getEmail())
            .password(saved.getPassword())
            .roles(saved.getRole().name())
            .build();

        String token = jwtService.generateToken(principal, Map.of("role", saved.getRole().name()));
        BogdanovBogdanAuthResponse response = new BogdanovBogdanAuthResponse();
        response.setToken(token);
        response.setUser(BogdanovBogdanUserMapper.toResponse(saved));
        return response;
    }

    @Override
    public BogdanovBogdanAuthResponse login(BogdanovBogdanAuthLoginRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        BogdanovBogdanUser user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new BogdanovBogdanBadRequestException("Invalid credentials"));

        UserDetails principal = org.springframework.security.core.userdetails.User
            .withUsername(user.getEmail())
            .password(user.getPassword())
            .roles(user.getRole().name())
            .build();

        String token = jwtService.generateToken(principal, Map.of("role", user.getRole().name()));
        BogdanovBogdanAuthResponse response = new BogdanovBogdanAuthResponse();
        response.setToken(token);
        response.setUser(BogdanovBogdanUserMapper.toResponse(user));
        return response;
    }
}
