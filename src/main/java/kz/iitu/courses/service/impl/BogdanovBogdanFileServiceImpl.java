package kz.iitu.courses.service.impl;

import kz.iitu.courses.dto.file.BogdanovBogdanFileResponse;
import kz.iitu.courses.exception.BogdanovBogdanNotFoundException;
import kz.iitu.courses.mapper.BogdanovBogdanFileMapper;
import kz.iitu.courses.model.BogdanovBogdanFileAsset;
import kz.iitu.courses.repository.BogdanovBogdanFileAssetRepository;
import kz.iitu.courses.service.BogdanovBogdanFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.OffsetDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BogdanovBogdanFileServiceImpl implements BogdanovBogdanFileService {
    private final BogdanovBogdanFileAssetRepository fileAssetRepository;

    @Value("${file.storage-path}")
    private String storagePath;

    @Override
    public BogdanovBogdanFileResponse upload(MultipartFile file) {
        try {
            Path root = Path.of(storagePath).toAbsolutePath().normalize();
            Files.createDirectories(root);

            String originalName = StringUtils.cleanPath(file.getOriginalFilename());
            String storedName = UUID.randomUUID() + "_" + originalName;
            Path destination = root.resolve(storedName);
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

            BogdanovBogdanFileAsset asset = new BogdanovBogdanFileAsset();
            asset.setOriginalName(originalName);
            asset.setStoredName(storedName);
            asset.setContentType(file.getContentType());
            asset.setSize(file.getSize());
            asset.setUploadedAt(OffsetDateTime.now());

            return BogdanovBogdanFileMapper.toResponse(fileAssetRepository.save(asset));
        } catch (IOException ex) {
            throw new BogdanovBogdanNotFoundException("File upload failed");
        }
    }

    @Override
    public Resource download(Long id) {
        BogdanovBogdanFileAsset asset = getEntity(id);
        Path root = Path.of(storagePath).toAbsolutePath().normalize();
        return new FileSystemResource(root.resolve(asset.getStoredName()));
    }

    @Override
    public BogdanovBogdanFileAsset getEntity(Long id) {
        return fileAssetRepository.findById(id)
            .orElseThrow(() -> new BogdanovBogdanNotFoundException("File not found"));
    }
}
