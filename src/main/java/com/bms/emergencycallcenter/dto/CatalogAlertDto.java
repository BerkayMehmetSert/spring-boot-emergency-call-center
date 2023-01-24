package com.bms.emergencycallcenter.dto;

public record CatalogAlertDto(
        String id,
        Boolean alwaysAlert,
        String emergencyId
) {
}
