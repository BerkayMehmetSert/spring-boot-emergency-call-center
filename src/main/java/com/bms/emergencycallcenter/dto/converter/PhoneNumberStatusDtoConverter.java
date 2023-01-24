package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.PhoneNumberStatusDto;
import com.bms.emergencycallcenter.model.PhoneNumberStatus;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PhoneNumberStatusDtoConverter {
    private final StatusPhoneNumberDtoConverter phoneNumberDtoConverter;

    public PhoneNumberStatusDtoConverter(StatusPhoneNumberDtoConverter phoneNumberDtoConverter) {
        this.phoneNumberDtoConverter = phoneNumberDtoConverter;
    }

    public PhoneNumberStatusDto convert(PhoneNumberStatus from) {
        return new PhoneNumberStatusDto(
                from.getId(),
                from.getName(),
                from.getPhoneNumbers() != null ? phoneNumberDtoConverter.convert(from.getPhoneNumbers()) : null
        );
    }

    public Set<PhoneNumberStatusDto> convert(Set<PhoneNumberStatus> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
