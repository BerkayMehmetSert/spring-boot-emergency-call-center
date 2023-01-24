package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.CallStatusDto;
import com.bms.emergencycallcenter.model.CallStatus;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CallStatusDtoConverter {
    private final StatusCallDtoConverter callDtoConverter;

    public CallStatusDtoConverter(StatusCallDtoConverter callDtoConverter) {
        this.callDtoConverter = callDtoConverter;
    }

    public CallStatusDto convert(CallStatus from) {
        return new CallStatusDto(
                from.getId(),
                from.getName(),
                from.getCalls() != null ? callDtoConverter.convert(from.getCalls()) : null
        );
    }

    public Set<CallStatusDto> convert(Set<CallStatus> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
