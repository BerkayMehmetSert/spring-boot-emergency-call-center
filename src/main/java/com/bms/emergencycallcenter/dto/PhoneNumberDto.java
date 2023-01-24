package com.bms.emergencycallcenter.dto;

import java.util.Set;

public record PhoneNumberDto(
        String id,
        String number,
        String notes,
        String statusId,
        Set<PhoneCallDto> calls
) {
}
