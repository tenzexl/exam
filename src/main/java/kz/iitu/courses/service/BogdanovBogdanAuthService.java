package kz.iitu.courses.service;

import kz.iitu.courses.dto.auth.BogdanovBogdanAuthLoginRequest;
import kz.iitu.courses.dto.auth.BogdanovBogdanAuthRegisterRequest;
import kz.iitu.courses.dto.auth.BogdanovBogdanAuthResponse;

public interface BogdanovBogdanAuthService {
    BogdanovBogdanAuthResponse register(BogdanovBogdanAuthRegisterRequest request);
    BogdanovBogdanAuthResponse login(BogdanovBogdanAuthLoginRequest request);
}
