package com.bms.emergencycallcenter.dto;

import java.time.LocalDateTime;

public record PhoneCallDto(
        String id,
        LocalDateTime callStartTime,
        LocalDateTime callEndTime,
        Integer callDuration,
        String notes,
        String operatorId,
        String statusId,
        String cityId
) {
}
