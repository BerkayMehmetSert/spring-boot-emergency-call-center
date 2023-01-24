package com.bms.emergencycallcenter.dto;

public record AlertedServiceDto(
        String id,
        String emergencyId,
        String actionId
) {
}
