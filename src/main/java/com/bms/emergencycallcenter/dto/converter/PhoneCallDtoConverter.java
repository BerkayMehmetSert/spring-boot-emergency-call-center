package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.PhoneCallDto;
import com.bms.emergencycallcenter.model.Call;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PhoneCallDtoConverter {
    public PhoneCallDto convert(Call from) {
        return new PhoneCallDto(
                from.getId(),
                from.getCallStartTime(),
                from.getCallEndTime(),
                from.getCallDuration(),
                from.getNotes(),
                Objects.requireNonNull(from.getOperator()).getId(),
                Objects.requireNonNull(from.getStatus()).getId(),
                Objects.requireNonNull(from.getCity()).getId()
        );
    }

    public Set<PhoneCallDto> convert(Set<Call> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
