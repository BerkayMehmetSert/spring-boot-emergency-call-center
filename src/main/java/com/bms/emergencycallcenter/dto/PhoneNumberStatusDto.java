package com.bms.emergencycallcenter.dto;

import java.util.Set;

public record PhoneNumberStatusDto(
        String id,
        String name,
        Set<StatusPhoneNumberDto> phoneNumbers
) {
}
