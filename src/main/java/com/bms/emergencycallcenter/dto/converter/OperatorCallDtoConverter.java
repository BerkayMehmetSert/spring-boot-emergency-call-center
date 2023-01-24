package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.OperatorCallDto;
import com.bms.emergencycallcenter.model.Call;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OperatorCallDtoConverter {
    public OperatorCallDto convert(Call from) {
        return new OperatorCallDto(
                from.getId(),
                from.getCallStartTime(),
                from.getCallEndTime(),
                from.getCallDuration(),
                from.getNotes(),
                Objects.requireNonNull(from.getPhoneNumber()).getId(),
                Objects.requireNonNull(from.getStatus()).getId(),
                Objects.requireNonNull(from.getCity()).getId()
        );
    }

    public Set<OperatorCallDto> convert(Set<Call> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
