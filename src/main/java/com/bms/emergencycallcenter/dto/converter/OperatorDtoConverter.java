package com.bms.emergencycallcenter.dto.converter;

import com.bms.emergencycallcenter.dto.OperatorDto;
import com.bms.emergencycallcenter.model.Operator;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OperatorDtoConverter {
    private final OperatorCallDtoConverter callDtoConverter;

    public OperatorDtoConverter(OperatorCallDtoConverter callDtoConverter) {
        this.callDtoConverter = callDtoConverter;
    }

    public OperatorDto convert(Operator from) {
        return new OperatorDto(
                from.getId(),
                from.getCode(),
                from.getFirstName(),
                from.getLastName(),
                from.getCalls() != null ? callDtoConverter.convert(from.getCalls()) : null
        );
    }

    public Set<OperatorDto> convert(Set<Operator> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
