package com.bms.emergencycallcenter.dto;

public record EmergencyAlertDto(
        String id,
        Boolean alwaysAlert,
        String catalogId
) {
}
