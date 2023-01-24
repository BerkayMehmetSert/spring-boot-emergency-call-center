package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.ActionDto;
import com.bms.emergencycallcenter.model.Action;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ActionDtoConverter {
    private final ActionAlertedServiceDtoConverter alertedServiceDtoConverter;

    public ActionDtoConverter(ActionAlertedServiceDtoConverter alertedServiceDtoConverter) {
        this.alertedServiceDtoConverter = alertedServiceDtoConverter;
    }

    public ActionDto convert(Action from) {
        return new ActionDto(
                from.getId(),
                from.getNotes(),
                Objects.requireNonNull(from.getCatalog()).getId(),
                Objects.requireNonNull(from.getCall()).getId(),
                from.getAlertedService() != null ? alertedServiceDtoConverter.convert(from.getAlertedService()) : null
        );
    }

    public Set<ActionDto> convert(Set<Action> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
