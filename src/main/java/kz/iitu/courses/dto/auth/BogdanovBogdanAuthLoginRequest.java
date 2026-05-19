package kz.iitu.courses.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BogdanovBogdanAuthLoginRequest {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
