package com.bms.emergencycallcenter.dto;

import java.util.Set;

public record CityDto(
        String id,
        String name,
        Set<CityCallDto> calls
) {
}
