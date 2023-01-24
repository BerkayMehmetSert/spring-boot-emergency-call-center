package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.CatalogAlertDto;
import com.bms.emergencycallcenter.model.Alert;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CatalogAlertedDtoConverter {
    public CatalogAlertDto convert(Alert from) {
        return new CatalogAlertDto(
                from.getId(),
                from.getAlwaysAlert(),
                Objects.requireNonNull(from.getEmergency()).getId()
        );
    }

    public Set<CatalogAlertDto> convert(Set<Alert> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
