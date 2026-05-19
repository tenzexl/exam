package kz.iitu.courses.mapper;

import kz.iitu.courses.dto.file.BogdanovBogdanFileResponse;
import kz.iitu.courses.model.BogdanovBogdanFileAsset;

public class BogdanovBogdanFileMapper {
    public static BogdanovBogdanFileResponse toResponse(BogdanovBogdanFileAsset fileAsset) {
        BogdanovBogdanFileResponse response = new BogdanovBogdanFileResponse();
        response.setId(fileAsset.getId());
        response.setOriginalName(fileAsset.getOriginalName());
        response.setContentType(fileAsset.getContentType());
        response.setSize(fileAsset.getSize());
        response.setUploadedAt(fileAsset.getUploadedAt());
        return response;
    }
}
