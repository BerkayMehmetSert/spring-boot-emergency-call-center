package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.AlertDto;
import com.bms.emergencycallcenter.model.Alert;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AlertDtoConverter {
    public AlertDto convert(Alert from) {
        return new AlertDto(
                from.getId(),
                from.getAlwaysAlert(),
                Objects.requireNonNull(from.getEmergency()).getId(),
                Objects.requireNonNull(from.getCatalog()).getId()
        );
    }

    public Set<AlertDto> convert(Set<Alert> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
