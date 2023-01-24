package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.PhoneNumberDto;
import com.bms.emergencycallcenter.model.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PhoneNumberDtoConverter {
    private final PhoneCallDtoConverter callDtoConverter;

    public PhoneNumberDtoConverter(PhoneCallDtoConverter callDtoConverter) {
        this.callDtoConverter = callDtoConverter;
    }

    public PhoneNumberDto convert(PhoneNumber from) {
        return new PhoneNumberDto(
                from.getId(),
                from.getNumber(),
                from.getNotes(),
                Objects.requireNonNull(from.getStatus()).getId(),
                from.getCalls() != null ? callDtoConverter.convert(from.getCalls()) : null
        );
    }

    public Set<PhoneNumberDto> convert(Set<PhoneNumber> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
