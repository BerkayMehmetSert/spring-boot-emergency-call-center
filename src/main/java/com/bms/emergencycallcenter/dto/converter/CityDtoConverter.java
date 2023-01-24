package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.CityDto;
import com.bms.emergencycallcenter.model.City;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CityDtoConverter {
    private final CityCallDtoConverter callDtoConverter;

    public CityDtoConverter(CityCallDtoConverter callDtoConverter) {
        this.callDtoConverter = callDtoConverter;
    }

    public CityDto convert(City from) {
        return new CityDto(
                from.getId(),
                from.getName(),
                from.getCalls() != null ? callDtoConverter.convert(from.getCalls()) : null
        );
    }

    public Set<CityDto> convert(Set<City> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
