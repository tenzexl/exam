package kz.iitu.courses.dto.user;

import kz.iitu.courses.model.BogdanovBogdanRole;
import lombok.Data;

@Data
public class BogdanovBogdanUserResponse {
    private Long id;
    private String email;
    private String fullName;
    private BogdanovBogdanRole role;
}
