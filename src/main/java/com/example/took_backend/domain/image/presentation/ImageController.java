package com.example.took_backend.domain.image.presentation;

import com.example.took_backend.domain.image.service.ImageUploadService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageUploadService imageUploadService;

    @PostMapping
    public ResponseEntity<List<String>> uploadFile(@Valid @RequestPart(value = "files", required = false) List<MultipartFile> multipartFilesList){
        List<String> fileUrl = imageUploadService.upload(multipartFilesList);
        return new ResponseEntity<>(fileUrl,HttpStatus.OK);
    }
}
