package com.bms.emergencycallcenter.service;

import com.bms.emergencycallcenter.dto.CallDto;
import com.bms.emergencycallcenter.dto.converter.CallDtoConverter;
import com.bms.emergencycallcenter.exception.CallNotFoundException;
import com.bms.emergencycallcenter.helper.message.BusinessMessage;
import com.bms.emergencycallcenter.helper.message.LogMessage;
import com.bms.emergencycallcenter.model.Call;
import com.bms.emergencycallcenter.repository.CallRepository;
import com.bms.emergencycallcenter.request.call.CreateCallRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class CallService {
    private final CallRepository callRepository;
    private final OperatorService operatorService;
    private final PhoneNumberService phoneNumberService;
    private final CallStatusService callStatusService;
    private final CityService cityService;
    private final CallDtoConverter converter;
    private static final Logger logger = LoggerFactory.getLogger(CallService.class);

    public CallService(CallRepository callRepository,
                       OperatorService operatorService,
                       PhoneNumberService phoneNumberService,
                       CallStatusService callStatusService,
                       CityService cityService,
                       CallDtoConverter converter) {
        this.callRepository = callRepository;
        this.operatorService = operatorService;
        this.phoneNumberService = phoneNumberService;
        this.callStatusService = callStatusService;
        this.cityService = cityService;
        this.converter = converter;
    }

    public void createCall(final CreateCallRequest request) {
        Call call = new Call(
                request.getCallStartTime(),
                request.getCallEndTime(),
                getCallDuration(request.getCallStartTime(), request.getCallEndTime()),
                request.getNotes(),
                operatorService.getOperatorById(request.getOperatorId()),
                phoneNumberService.getPhoneNumberById(request.getPhoneNumberId()),
                callStatusService.getCallStatusById(request.getCallStatusId()),
                cityService.getCityById(request.getCityId())
        );

        callRepository.save(call);
        logger.info(LogMessage.Call.CALL_CREATED + call.getId());
    }

    public void deleteCall(final String id) {
        callRepository.delete(getCallById(id));
        logger.info(LogMessage.Call.CALL_DELETED + id);
    }

    public Set<CallDto> findCallsByOperatorId(final String operatorId) {
        Set<Call> calls = callRepository.findByOperator_Id(operatorId);

        if (calls.isEmpty()) {
            logger.error(LogMessage.Call.CALL_NOT_FOUND_BY_OPERATOR_ID + operatorId);
            throw new CallNotFoundException(BusinessMessage.Call.CALL_NOT_FOUND_BY_OPERATOR_ID + operatorId);
        }

        logger.info(LogMessage.Call.CALLS_FOUND_BY_OPERATOR_ID + operatorId);
        return converter.convert(calls);
    }

    public Set<CallDto> findCallsByPhoneNumber(final String number) {
        Set<Call> calls = callRepository.findByPhoneNumber_Number(number);

        if (calls.isEmpty()) {
            logger.error(LogMessage.Call.CALL_NOT_FOUND_BY_PHONE_NUMBER + number);
            throw new CallNotFoundException(BusinessMessage.Call.CALL_NOT_FOUND_BY_PHONE_NUMBER + number);
        }

        logger.info(LogMessage.Call.CALLS_FOUND_BY_PHONE_NUMBER + number);
        return converter.convert(calls);
    }

    public Set<CallDto> findCallsByStatus(final String statusName) {
        Set<Call> calls = callRepository.findByStatus_Name(statusName);

        if (calls.isEmpty()) {
            logger.error(LogMessage.Call.CALL_NOT_FOUND_BY_STATUS + statusName);
            throw new CallNotFoundException(BusinessMessage.Call.CALL_NOT_FOUND_BY_STATUS + statusName);
        }

        logger.info(LogMessage.Call.CALLS_FOUND_BY_STATUS + statusName);
        return converter.convert(calls);
    }

    public Set<CallDto> findCallsByCity(final String cityName) {
        Set<Call> calls = callRepository.findByCity_Name(cityName);

        if (calls.isEmpty()) {
            logger.error(LogMessage.Call.CALL_NOT_FOUND_BY_CITY + cityName);
            throw new CallNotFoundException(BusinessMessage.Call.CALL_NOT_FOUND_BY_CITY + cityName);
        }

        logger.info(LogMessage.Call.CALLS_FOUND_BY_CITY + cityName);
        return converter.convert(calls);
    }

    public Set<CallDto> findAllCalls() {
        Set<Call> calls = new HashSet<>(callRepository.findAll());

        if (calls.isEmpty()) {
            logger.error(LogMessage.Call.CALL_LIST_EMPTY);
            throw new CallNotFoundException(BusinessMessage.Call.CALL_LIST_EMPTY);
        }

        logger.info(LogMessage.Call.CALL_LIST + calls.size());
        return converter.convert(calls);
    }

    protected Call getCallById(final String id) {
        return callRepository.findById(id).orElseThrow(() -> {
            logger.error(LogMessage.Call.CALL_NOT_FOUND + id);
            throw new CallNotFoundException(BusinessMessage.Call.CALL_NOT_FOUND + id);
        });
    }

    private Integer getCallDuration(final LocalDateTime callStartTime, final LocalDateTime callEndTime) {
        return callEndTime.getSecond() - callStartTime.getSecond();
    }
}
