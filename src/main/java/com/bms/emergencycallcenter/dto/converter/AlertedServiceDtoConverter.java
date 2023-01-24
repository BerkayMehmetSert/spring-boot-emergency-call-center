package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.AlertedServiceDto;
import com.bms.emergencycallcenter.model.AlertedService;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AlertedServiceDtoConverter {
    public AlertedServiceDto convert(AlertedService from) {
        return new AlertedServiceDto(
                from.getId(),
                Objects.requireNonNull(from.getEmergency()).getId(),
                Objects.requireNonNull(from.getAction()).getId()
        );
    }

    public Set<AlertedServiceDto> convert(Set<AlertedService> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
