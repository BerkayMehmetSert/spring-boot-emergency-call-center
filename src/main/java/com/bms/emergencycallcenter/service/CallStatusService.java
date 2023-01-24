package com.bms.emergencycallcenter.service;

import com.bms.emergencycallcenter.dto.CallStatusDto;
import com.bms.emergencycallcenter.dto.converter.CallStatusDtoConverter;
import com.bms.emergencycallcenter.exception.CallStatusAlreadyExistException;
import com.bms.emergencycallcenter.exception.CallStatusNotFoundException;
import com.bms.emergencycallcenter.helper.message.BusinessMessage;
import com.bms.emergencycallcenter.helper.message.LogMessage;
import com.bms.emergencycallcenter.model.CallStatus;
import com.bms.emergencycallcenter.repository.CallStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CallStatusService {
    private final CallStatusRepository callStatusRepository;
    private final CallStatusDtoConverter converter;
    private static final Logger logger = LoggerFactory.getLogger(CallStatusService.class);

    public CallStatusService(CallStatusRepository callStatusRepository,
                             CallStatusDtoConverter converter) {
        this.callStatusRepository = callStatusRepository;
        this.converter = converter;
    }

    public void createCallStatus(final String name) {
        checkIfCallStatusExists(name);

        callStatusRepository.save(new CallStatus(name));
        logger.info(LogMessage.CallStatus.CALL_STATUS_CREATED + name);
    }

    public void updateCallStatus(final String id, final String name) {
        CallStatus callStatus = getCallStatusById(id);

        if (!callStatus.getName().equalsIgnoreCase(name)) {
            checkIfCallStatusExists(name);
        }

        CallStatus updatedCallStatus = new CallStatus(
                callStatus.getId(),
                name,
                callStatus.getCalls()
        );

        callStatusRepository.save(updatedCallStatus);
        logger.info(LogMessage.CallStatus.CALL_STATUS_UPDATED + id);
    }

    public void deleteCallStatus(final String id) {
        callStatusRepository.delete(getCallStatusById(id));
        logger.info(LogMessage.CallStatus.CALL_STATUS_DELETED + id);
    }

    public CallStatusDto findCallStatusByName(final String name) {
        CallStatus callStatus = callStatusRepository.findByNameIgnoreCase(name).orElseThrow(() -> {
            logger.error(LogMessage.CallStatus.CALL_STATUS_NOT_FOUND_BY_NAME + name);
            throw new CallStatusNotFoundException(BusinessMessage.CallStatus.CALL_STATUS_NOT_FOUND_BY_NAME + name);
        });
        logger.info(LogMessage.CallStatus.CALL_STATUS_FOUND_BY_NAME + name);
        return converter.convert(callStatus);
    }

    public Set<CallStatusDto> findAllCallStatuses() {
        Set<CallStatus> callStatuses = new HashSet<>(callStatusRepository.findAll());

        if (callStatuses.isEmpty()) {
            logger.error(LogMessage.CallStatus.CALL_STATUS_LIST_EMPTY);
            throw new CallStatusNotFoundException(BusinessMessage.CallStatus.CALL_STATUS_LIST_EMPTY);
        }

        logger.info(LogMessage.CallStatus.CALL_STATUS_LIST + callStatuses.size());
        return converter.convert(callStatuses);
    }

    protected CallStatus getCallStatusById(final String id) {
        return callStatusRepository.findById(id).orElseThrow(() -> {
            logger.error(LogMessage.CallStatus.CALL_STATUS_NOT_FOUND + id);
            throw new CallStatusNotFoundException(BusinessMessage.CallStatus.CALL_STATUS_NOT_FOUND + id);
        });
    }

    private void checkIfCallStatusExists(final String name) {
        if (callStatusRepository.existsByNameIgnoreCase(name)) {
            logger.error(LogMessage.CallStatus.CALL_STATUS_ALREADY_EXISTS + name);
            throw new CallStatusAlreadyExistException(BusinessMessage.CallStatus.CALL_STATUS_ALREADY_EXISTS + name);
        }
    }
}
