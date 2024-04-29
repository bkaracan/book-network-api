package com.bkaracan.book.service;

import com.bkaracan.book.entity.Book;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String saveFile(MultipartFile file, Long id);
}
