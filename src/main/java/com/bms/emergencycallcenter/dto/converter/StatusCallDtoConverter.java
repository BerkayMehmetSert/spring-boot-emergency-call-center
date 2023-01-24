package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.StatusCallDto;
import com.bms.emergencycallcenter.model.Call;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StatusCallDtoConverter {
    public StatusCallDto convert(Call from) {
        return new StatusCallDto(
                from.getId(),
                from.getCallStartTime(),
                from.getCallEndTime(),
                from.getCallDuration(),
                from.getNotes(),
                Objects.requireNonNull(from.getOperator()).getId(),
                Objects.requireNonNull(from.getPhoneNumber()).getId(),
                Objects.requireNonNull(from.getCity()).getId()
        );
    }

    public Set<StatusCallDto> convert(Set<Call> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
