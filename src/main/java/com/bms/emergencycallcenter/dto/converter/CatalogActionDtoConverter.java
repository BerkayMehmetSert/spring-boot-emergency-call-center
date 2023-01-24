package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.CatalogActionDto;
import com.bms.emergencycallcenter.model.Action;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CatalogActionDtoConverter {
    public CatalogActionDto convert(Action from) {
        return new CatalogActionDto(
                from.getId(),
                from.getNotes(),
                Objects.requireNonNull(from.getCatalog()).getId(),
                Objects.requireNonNull(from.getCall()).getId()
        );
    }

    public Set<CatalogActionDto> convert(Set<Action> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
