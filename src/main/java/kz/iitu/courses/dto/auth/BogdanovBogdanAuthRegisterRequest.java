package kz.iitu.courses.dto.auth;

import kz.iitu.courses.model.BogdanovBogdanRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class BogdanovBogdanAuthRegisterRequest {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, max = 100)
    private String password;

    @NotBlank
    private String fullName;

    private BogdanovBogdanRole role;
}
