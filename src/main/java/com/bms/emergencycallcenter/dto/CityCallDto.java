package com.bms.emergencycallcenter.dto;

import java.time.LocalDateTime;

public record CityCallDto(
        String id,
        LocalDateTime callStartTime,
        LocalDateTime callEndTime,
        Integer callDuration,
        String notes,
        String operatorId,
        String phoneNumberId,
        String statusId
) {
}
