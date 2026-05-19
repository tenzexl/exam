package kz.iitu.courses.service;

import kz.iitu.courses.dto.user.BogdanovBogdanUserCreateRequest;
import kz.iitu.courses.dto.user.BogdanovBogdanUserResponse;

import java.util.List;

public interface BogdanovBogdanUserService {
    BogdanovBogdanUserResponse create(BogdanovBogdanUserCreateRequest request);
    BogdanovBogdanUserResponse getById(Long id);
    List<BogdanovBogdanUserResponse> getAll();
    void delete(Long id);
}
