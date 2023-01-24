package com.bms.emergencycallcenter.dto;

import java.util.Set;

public record OperatorDto(
        String id,
        String code,
        String firstName,
        String lastName,
        Set<OperatorCallDto> calls
) {
}
