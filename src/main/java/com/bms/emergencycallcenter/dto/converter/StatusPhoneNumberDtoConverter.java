package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.StatusPhoneNumberDto;
import com.bms.emergencycallcenter.model.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StatusPhoneNumberDtoConverter {
    public StatusPhoneNumberDto convert(PhoneNumber from) {
        return new StatusPhoneNumberDto(
                from.getId(),
                from.getNumber(),
                from.getNotes()
        );
    }

    public Set<StatusPhoneNumberDto> convert(Set<PhoneNumber> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
