package com.libra.loans_service.controller;

import com.libra.loans_service.dto.LoansDto;
import com.libra.loans_service.dto.LoansRequest;
import com.libra.loans_service.service.LoansService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/loans")
@RestController
@Validated
@RequiredArgsConstructor
public class LoansController {

    private final LoansService loansService;


    @PostMapping
    public ResponseEntity<LoansDto> createLoan(@RequestBody @Validated LoansRequest loansDto) {
        return new ResponseEntity<>(loansService.createLoan(loansDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoansDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(loansService.getLoanById(id));
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<LoansDto> returnBook(@PathVariable Long id) {
        return ResponseEntity.ok(loansService.returnBook(id));
    }
    
}
