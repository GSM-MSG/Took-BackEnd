package com.example.took_backend.domain.image.presentation;

import com.example.took_backend.domain.image.exception.FailedToUploadException;
import com.example.took_backend.domain.image.service.ImageUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageUploadService imageUploadService;

    @PostMapping
    public ResponseEntity<List<String>> uploadFile(@Valid @RequestParam("images")List<MultipartFile> multipartFilesList){
        List<String> fileUrl = imageUploadService.upload(multipartFilesList).orElseThrow(()-> new FailedToUploadException("업로드 실패"));
        return new ResponseEntity<>(fileUrl,HttpStatus.OK);
    }
}
