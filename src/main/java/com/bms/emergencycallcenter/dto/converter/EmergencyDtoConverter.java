package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.EmergencyDto;
import com.bms.emergencycallcenter.model.Emergency;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EmergencyDtoConverter {
    private final EmergencyAlertedServiceDtoConverter alertedServiceDtoConverter;
    private final EmergencyAlertDtoConverter alertDtoConverter;

    public EmergencyDtoConverter(EmergencyAlertedServiceDtoConverter alertedServiceDtoConverter,
                                 EmergencyAlertDtoConverter alertDtoConverter) {
        this.alertedServiceDtoConverter = alertedServiceDtoConverter;
        this.alertDtoConverter = alertDtoConverter;
    }

    public EmergencyDto convert(Emergency from) {
        return new EmergencyDto(
                from.getId(),
                from.getName(),
                from.getDetails(),
                from.getAlertedService() != null ? alertedServiceDtoConverter.convert(from.getAlertedService()) : null,
                from.getAlert() != null ? alertDtoConverter.convert(from.getAlert()) : null
        );
    }

    public Set<EmergencyDto> convert(Set<Emergency> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
