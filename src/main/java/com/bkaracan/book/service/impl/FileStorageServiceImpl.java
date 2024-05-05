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

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class FileStorageServiceImpl implements FileStorageService {

    @Value("${application.file.upload.photos-output-path}")
    private String fileUploadPath;

    @Override
    public String saveFile(@NonNull MultipartFile sourceFile, @NonNull Long userId) {
        if (userId < 0) {
            log.error("Invalid user ID");
            return null;
        }

        final String sanitizedUserId = sanitizeUserId(userId);
        final String fileUploadSubPath = "users" + File.separator + sanitizedUserId;
        return uploadFile(sourceFile, fileUploadSubPath);
    }

    private String sanitizeUserId(Long userId) {
        return userId.toString();
    }

    private String uploadFile(@NonNull MultipartFile sourceFile, @NonNull String fileUploadSubPath) {
        final String finalUploadPath = fileUploadPath + File.separator + fileUploadSubPath;
        File targetFolder = new File(finalUploadPath);
        if (!targetFolder.exists()) {
            boolean folderCreated = targetFolder.mkdirs();
            if (!folderCreated) {
                log.warn("Failed to create the target folder!");
                return null;
            }
        }
        final String fileExtension = getFileExtension(sourceFile.getOriginalFilename());
        String targetFilePath = finalUploadPath + File.separator + System.currentTimeMillis() + "." + fileExtension;
        Path targetPath = Paths.get(targetFilePath);
        try {
            Files.write(targetPath, sourceFile.getBytes());
            log.info("File saved to " + targetFilePath);
        } catch (IOException e) {
            log.error("File was not saved!", e);
        }
        return null;
    }

    private String getFileExtension(String filename) {
        if(filename == null || filename.isEmpty()) {
            return "";
        }
        int lastDotIndex = filename.lastIndexOf(".");
        if(lastDotIndex == -1) {
            return "";
        }
        return filename.substring(lastDotIndex + 1).toLowerCase();
    }
}
