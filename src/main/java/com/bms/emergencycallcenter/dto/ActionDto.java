package com.bms.emergencycallcenter.dto;

import java.util.Set;

public record ActionDto(
        String id,
        String notes,
        String catalogId,
        String callId,
        Set<ActionAlertedServiceDto> alertedServices
) {
}
