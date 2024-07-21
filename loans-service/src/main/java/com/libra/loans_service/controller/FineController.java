package com.libra.loans_service.controller;

import com.libra.loans_service.dto.FineDto;
import com.libra.loans_service.dto.FineFilter;
import com.libra.loans_service.service.FineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/fines")
@RequiredArgsConstructor
public class FineController {

    private final FineService fineService;

    @GetMapping
    public ResponseEntity<Page<FineDto>> getAll(FineFilter fineFilter,Pageable pageable) {
        return new ResponseEntity<>(fineService.getAll(fineFilter,pageable),HttpStatus.OK);
    }
}
