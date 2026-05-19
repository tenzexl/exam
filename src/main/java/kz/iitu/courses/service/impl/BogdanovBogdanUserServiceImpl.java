package kz.iitu.courses.service.impl;

import kz.iitu.courses.dto.user.BogdanovBogdanUserCreateRequest;
import kz.iitu.courses.dto.user.BogdanovBogdanUserResponse;
import kz.iitu.courses.exception.BogdanovBogdanBadRequestException;
import kz.iitu.courses.exception.BogdanovBogdanNotFoundException;
import kz.iitu.courses.mapper.BogdanovBogdanUserMapper;
import kz.iitu.courses.model.BogdanovBogdanRole;
import kz.iitu.courses.model.BogdanovBogdanUser;
import kz.iitu.courses.repository.BogdanovBogdanUserRepository;
import kz.iitu.courses.service.BogdanovBogdanUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BogdanovBogdanUserServiceImpl implements BogdanovBogdanUserService {
    private final BogdanovBogdanUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public BogdanovBogdanUserResponse create(BogdanovBogdanUserCreateRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BogdanovBogdanBadRequestException("Email already exists");
        }
        BogdanovBogdanUser user = new BogdanovBogdanUser();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFullName(request.getFullName());
        user.setRole(request.getRole() == null ? BogdanovBogdanRole.STUDENT : request.getRole());
        return BogdanovBogdanUserMapper.toResponse(userRepository.save(user));
    }

    @Override
    public BogdanovBogdanUserResponse getById(Long id) {
        BogdanovBogdanUser user = userRepository.findById(id)
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("User not found"));
        return BogdanovBogdanUserMapper.toResponse(user);
    }

    @Override
    public List<BogdanovBogdanUserResponse> getAll() {
        return userRepository.findAll().stream().map(BogdanovBogdanUserMapper::toResponse).toList();
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new BogdanovBogdanNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }
}
