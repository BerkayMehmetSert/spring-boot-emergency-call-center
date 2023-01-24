package com.bms.emergencycallcenter.dto;

import java.util.Set;

public record CountryDto(
        String id,
        String name,
        Set<CountryCityDto> cities
) {
}
