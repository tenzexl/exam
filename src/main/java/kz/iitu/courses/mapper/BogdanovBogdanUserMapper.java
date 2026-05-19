package kz.iitu.courses.mapper;

import kz.iitu.courses.dto.user.BogdanovBogdanUserResponse;
import kz.iitu.courses.model.BogdanovBogdanUser;

public class BogdanovBogdanUserMapper {
    public static BogdanovBogdanUserResponse toResponse(BogdanovBogdanUser user) {
        BogdanovBogdanUserResponse response = new BogdanovBogdanUserResponse();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setFullName(user.getFullName());
        response.setRole(user.getRole());
        return response;
    }
}
