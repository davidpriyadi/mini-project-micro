package com.libra.loans_service.dto.mapper;

import com.libra.loans_service.dto.FineDto;
import com.libra.loans_service.entity.Fines;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FineMapper {
    FineDto fineToFineDTO(Fines fine);
}
