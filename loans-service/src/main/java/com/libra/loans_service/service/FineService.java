package com.libra.loans_service.service;

import com.libra.loans_service.dto.FineDto;
import com.libra.loans_service.dto.FineFilter;
import com.libra.loans_service.dto.mapper.FineMapper;
import com.libra.loans_service.entity.Fines;
import com.libra.loans_service.repository.FineRepository;
import com.libra.loans_service.repository.spesification.FineSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FineService {

    private final FineRepository fineRepository;
    private final FineMapper fineMapper;


    public Page<FineDto> getAll(FineFilter fineFilter, Pageable pageable) {
        Specification<Fines> spec = Specification.where(null);

        if (fineFilter.getUserId() != null) {
            spec = spec.and(FineSpecification.hasUserId(fineFilter.getUserId()));
        }
        if (fineFilter.getStatus() != null) {
            spec = spec.and(FineSpecification.hasStatus(fineFilter.getStatus()));
        }
        if (fineFilter.getIssuedDate() != null) {
            spec = spec.and(FineSpecification.hasIssuedDate(fineFilter.getIssuedDate()));
        }
        if (fineFilter.getPaidDate() != null) {
            spec = spec.and(FineSpecification.hasPaidDate(fineFilter.getPaidDate()));
        }
        if (fineFilter.getBookId() != null) {
            spec = spec.and(FineSpecification.hasBookId(fineFilter.getBookId()));
        }

        return fineRepository.findAll(spec, pageable).map(fineMapper::fineToFineDTO);
    }
}
