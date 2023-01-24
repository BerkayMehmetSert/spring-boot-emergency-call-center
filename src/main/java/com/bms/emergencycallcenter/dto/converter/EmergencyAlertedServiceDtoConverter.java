package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.EmergencyAlertedServiceDto;
import com.bms.emergencycallcenter.model.AlertedService;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EmergencyAlertedServiceDtoConverter {
    public EmergencyAlertedServiceDto convert(AlertedService from) {
        return new EmergencyAlertedServiceDto(
                from.getId(),
                Objects.requireNonNull(from.getEmergency()).getId(),
                Objects.requireNonNull(from.getAction()).getId()
        );
    }

    public Set<EmergencyAlertedServiceDto> convert(Set<AlertedService> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
