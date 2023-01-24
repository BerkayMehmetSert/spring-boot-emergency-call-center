package com.bms.emergencycallcenter.dto;

import java.util.Set;

public record ActionCatalogDto(
        String id,
        String name,
        Set<CatalogAlertDto> alerts,
        Set<CatalogActionDto> actions
) {
}
