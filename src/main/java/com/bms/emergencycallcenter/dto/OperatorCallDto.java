package com.bms.emergencycallcenter.dto;

import java.time.LocalDateTime;

public record OperatorCallDto(
        String id,
        LocalDateTime callStartTime,
        LocalDateTime callEndTime,
        Integer callDuration,
        String notes,
        String phoneNumberId,
        String statusId,
        String cityId
) {
}
