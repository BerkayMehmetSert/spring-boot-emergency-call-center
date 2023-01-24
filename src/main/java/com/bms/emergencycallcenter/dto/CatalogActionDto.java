package com.bms.emergencycallcenter.dto;

public record CatalogActionDto(
        String id,
        String notes,
        String catalogId,
        String callId
) {
}
