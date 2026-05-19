package kz.iitu.courses.controller;

import kz.iitu.courses.dto.file.BogdanovBogdanFileResponse;
import kz.iitu.courses.model.BogdanovBogdanFileAsset;
import kz.iitu.courses.service.BogdanovBogdanFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class BogdanovBogdanFileController {
    private final BogdanovBogdanFileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<BogdanovBogdanFileResponse> upload(@RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(fileService.upload(file));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> download(@PathVariable Long id) {
        BogdanovBogdanFileAsset asset = fileService.getEntity(id);
        Resource resource = fileService.download(id);
        return ResponseEntity.ok()
            .contentType(asset.getContentType() == null ? MediaType.APPLICATION_OCTET_STREAM : MediaType.parseMediaType(asset.getContentType()))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + asset.getOriginalName() + "\"")
            .body(resource);
    }
}
