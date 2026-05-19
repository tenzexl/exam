package kz.iitu.courses.service;

import kz.iitu.courses.dto.file.BogdanovBogdanFileResponse;
import kz.iitu.courses.model.BogdanovBogdanFileAsset;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface BogdanovBogdanFileService {
    BogdanovBogdanFileResponse upload(MultipartFile file);
    Resource download(Long id);
    BogdanovBogdanFileAsset getEntity(Long id);
}
