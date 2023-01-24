package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.ActionAlertedServiceDto;
import com.bms.emergencycallcenter.model.AlertedService;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ActionAlertedServiceDtoConverter {
    public ActionAlertedServiceDto convert(AlertedService from) {
        return new ActionAlertedServiceDto(
                from.getId(),
                Objects.requireNonNull(from.getEmergency()).getId()
        );
    }

    public Set<ActionAlertedServiceDto> convert(Set<AlertedService> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
