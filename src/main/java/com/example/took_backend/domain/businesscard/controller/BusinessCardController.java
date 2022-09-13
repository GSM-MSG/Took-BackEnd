package com.example.took_backend.domain.businesscard.controller;

import com.example.took_backend.domain.businesscard.utils.ExchangeCardConverter;
import com.example.took_backend.domain.businesscard.data.dto.ExchangeCardListDto;
import com.example.took_backend.domain.businesscard.data.request.CreateBusinessCardRequest;
import com.example.took_backend.domain.businesscard.data.response.ExchangeCardListResponse;
import com.example.took_backend.domain.businesscard.service.CreateBusinessCardService;
import com.example.took_backend.domain.businesscard.service.ExchangeCardListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("business-cards")
@RequiredArgsConstructor
public class BusinessCardController {
    private final CreateBusinessCardService createBusinessCardService;
    private final ExchangeCardListService exchangeCardListService;
    private final ExchangeCardConverter exchangeCardConverter;

    @PostMapping
    public ResponseEntity<Void> createBusinessCard(@Valid @RequestBody CreateBusinessCardRequest createBusinessCardRequest){
        createBusinessCardService.execute(createBusinessCardRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ExchangeCardListResponse>> getExchangedBusinessCard(){
        ExchangeCardListDto exchangeCardListDto = exchangeCardListService.execute();
        List<ExchangeCardListResponse> exchangeCardListResponse = exchangeCardConverter.toResponse(exchangeCardListDto);
        return new ResponseEntity<>(exchangeCardListResponse,HttpStatus.OK);
    }
}
