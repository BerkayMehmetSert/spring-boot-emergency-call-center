package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.EmergencyAlertDto;
import com.bms.emergencycallcenter.model.Alert;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EmergencyAlertDtoConverter {
    public EmergencyAlertDto convert(Alert from) {
        return new EmergencyAlertDto(
                from.getId(),
                from.getAlwaysAlert(),
                Objects.requireNonNull(from.getCatalog()).getId()
        );
    }

    public Set<EmergencyAlertDto> convert(Set<Alert> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
