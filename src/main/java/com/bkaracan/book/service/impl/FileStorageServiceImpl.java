package com.bkaracan.book.service.impl;

import com.bkaracan.book.service.FileStorageService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${application.file.upload.photos-output-path}")
    private String fileUploadPath;

    @Override
    public String saveFile(
            @NonNull MultipartFile sourceFile,
            @NonNull Long userId) {
        final String fileUploadSubPath = "users" + File.separator + userId;
        return uploadFile(sourceFile, fileUploadSubPath);
    }

    private String uploadFile(@NonNull MultipartFile sourceFile, @NonNull String fileUploadSubPath) {
        String sanitizedFilename = sanitizeFilename(Objects.requireNonNull(sourceFile.getOriginalFilename()));
        if (sanitizedFilename.isEmpty()) {
            log.error("Invalid file name");
            return null;
        }

        final String finalUploadPath = fileUploadPath + File.separator + sanitizePath(fileUploadSubPath);
        File targetFolder = new File(finalUploadPath);
        if (!targetFolder.exists() && !targetFolder.mkdirs()) {
            log.warn("Failed to create the target folder!");
            return null;
        }

        String targetFilePath = finalUploadPath + File.separator + System.currentTimeMillis() + "." + getFileExtension(sanitizedFilename);
        Path targetPath = Paths.get(targetFilePath);
        try {
            Files.write(targetPath, sourceFile.getBytes());
            log.info("File saved to " + targetFilePath);
        } catch (IOException e) {
            log.error("File was not saved!", e);
            return null;
        }
        return null;
    }

    private String sanitizeFilename(String filename) {
        return filename.replaceAll("[^a-zA-Z0-9.\\-_]", "");
    }

    private String sanitizePath(String path) {
        return path.replaceAll("[^a-zA-Z0-9/]", "");
    }

    private String getFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf(".");
        if (lastDotIndex == -1 || lastDotIndex == 0) return "";
        return filename.substring(lastDotIndex + 1).toLowerCase();
    }
}
