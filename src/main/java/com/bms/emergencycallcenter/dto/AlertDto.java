package com.bms.emergencycallcenter.dto;

public record AlertDto(
        String id,
        Boolean alwaysAlert,
        String emergencyId,
        String catalogId
) {
}
