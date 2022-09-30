package com.example.took_backend.domain.business_card.presentation;

import com.example.took_backend.domain.business_card.presentation.dto.request.CreateBusinessCardRequest;
import com.example.took_backend.domain.business_card.presentation.dto.request.ExChangeBusinessCardRequest;
import com.example.took_backend.domain.business_card.presentation.dto.response.ExchangeCardListResponse;
import com.example.took_backend.domain.business_card.presentation.dto.response.ExchangeCardResponse;
import com.example.took_backend.domain.business_card.service.CreateBusinessCardService;
import com.example.took_backend.domain.business_card.service.ExChangeCardService;
import com.example.took_backend.domain.business_card.service.ExchangeCardListService;
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
    private final ExChangeCardService exChangeCardService;

    @PostMapping
    public ResponseEntity<Void> createBusinessCard(@Valid @RequestBody CreateBusinessCardRequest createBusinessCardRequest) {
        createBusinessCardService.execute(createBusinessCardRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ExchangeCardListResponse>> getExchangedBusinessCard() {
        List<ExchangeCardListResponse> exchangeCardListResponse = exchangeCardListService.execute();
        return new ResponseEntity<>(exchangeCardListResponse, HttpStatus.OK);
    }

    @PostMapping("/send")
    public ExchangeCardResponse exchangeCard(@RequestBody ExChangeBusinessCardRequest exChangeBusinessCardRequest) {
        return exChangeCardService.BusineessCardExchange(exChangeBusinessCardRequest);
    }
}