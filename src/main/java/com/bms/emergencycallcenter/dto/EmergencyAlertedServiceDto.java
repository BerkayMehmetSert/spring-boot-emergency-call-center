package com.bms.emergencycallcenter.dto;

public record EmergencyAlertedServiceDto(
        String id,
        String emergencyId,
        String actionId
) {
}
