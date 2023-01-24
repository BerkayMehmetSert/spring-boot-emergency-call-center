package com.bms.emergencycallcenter.dto;

import java.util.Set;

public record CallStatusDto(
        String id,
        String name,
        Set<StatusCallDto> calls
) {
}
