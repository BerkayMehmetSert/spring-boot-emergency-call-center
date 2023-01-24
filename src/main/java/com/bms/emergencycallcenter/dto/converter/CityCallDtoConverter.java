package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.CityCallDto;
import com.bms.emergencycallcenter.model.Call;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CityCallDtoConverter {
    public CityCallDto convert(Call from) {
        return new CityCallDto(
                from.getId(),
                from.getCallStartTime(),
                from.getCallEndTime(),
                from.getCallDuration(),
                from.getNotes(),
                Objects.requireNonNull(from.getOperator()).getId(),
                Objects.requireNonNull(from.getPhoneNumber()).getId(),
                Objects.requireNonNull(from.getStatus()).getId()
        );
    }

    public Set<CityCallDto> convert(Set<Call> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
