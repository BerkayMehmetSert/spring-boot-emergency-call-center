package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.ActionCatalogDto;
import com.bms.emergencycallcenter.model.ActionCatalog;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ActionCatalogDtoConverter {
    private final CatalogAlertedDtoConverter alertedDtoConverter;
    private final CatalogActionDtoConverter actionDtoConverter;

    public ActionCatalogDtoConverter(CatalogAlertedDtoConverter alertedDtoConverter,
                                     CatalogActionDtoConverter actionDtoConverter) {
        this.alertedDtoConverter = alertedDtoConverter;
        this.actionDtoConverter = actionDtoConverter;
    }

    public ActionCatalogDto convert(ActionCatalog from) {
        return new ActionCatalogDto(
                from.getId(),
                from.getName(),
                from.getAlerts() != null ? alertedDtoConverter.convert(from.getAlerts()) : null,
                from.getActions() != null ? actionDtoConverter.convert(from.getActions()) : null
        );
    }

    public Set<ActionCatalogDto> convert(Set<ActionCatalog> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
