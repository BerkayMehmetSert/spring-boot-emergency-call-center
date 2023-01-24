package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.CountryCityDto;
import com.bms.emergencycallcenter.model.City;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CountryCityDtoConverter {
    public CountryCityDto converter(City from) {
        return new CountryCityDto(from.getId(), from.getName());
    }

    public Set<CountryCityDto> converter(Set<City> from) {
        return from.stream().map(this::converter).collect(Collectors.toSet());
    }
}
