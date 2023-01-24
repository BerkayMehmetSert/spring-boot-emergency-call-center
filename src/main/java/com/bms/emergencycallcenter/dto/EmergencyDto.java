package com.bms.emergencycallcenter.dto;

import java.util.Set;

public record EmergencyDto(
        String id,
        String name,
        String details,
        Set<EmergencyAlertedServiceDto> alertedServices,
        Set<EmergencyAlertDto> alerts
) {
}
