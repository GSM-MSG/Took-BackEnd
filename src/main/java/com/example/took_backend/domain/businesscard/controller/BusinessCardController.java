package com.example.took_backend.domain.businesscard.controller;

import com.example.took_backend.domain.businesscard.data.request.CreateBusinessCardRequest;
import com.example.took_backend.domain.businesscard.service.CreateBusinessCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("business-cards")
@RequiredArgsConstructor
public class BusinessCardController {
    private final CreateBusinessCardService createBusinessCardService;

    @PostMapping
    public ResponseEntity<Void> createBusinessCard(@RequestBody CreateBusinessCardRequest createBusinessCardRequest){
        createBusinessCardService.execute(createBusinessCardRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
