package kz.iitu.courses.dto.auth;

import kz.iitu.courses.dto.user.BogdanovBogdanUserResponse;
import lombok.Data;

@Data
public class BogdanovBogdanAuthResponse {
    private String token;
    private BogdanovBogdanUserResponse user;
}
