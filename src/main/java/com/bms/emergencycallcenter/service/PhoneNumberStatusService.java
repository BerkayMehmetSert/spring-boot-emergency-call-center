package com.bms.emergencycallcenter.service;

import com.bms.emergencycallcenter.dto.PhoneNumberStatusDto;
import com.bms.emergencycallcenter.dto.converter.PhoneNumberStatusDtoConverter;
import com.bms.emergencycallcenter.exception.PhoneNumberStatusAlreadyExistException;
import com.bms.emergencycallcenter.exception.PhoneNumberStatusNotFoundException;
import com.bms.emergencycallcenter.helper.message.BusinessMessage;
import com.bms.emergencycallcenter.helper.message.LogMessage;
import com.bms.emergencycallcenter.model.PhoneNumberStatus;
import com.bms.emergencycallcenter.repository.PhoneNumberStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PhoneNumberStatusService {
    private final PhoneNumberStatusRepository phoneNumberStatusRepository;
    private final PhoneNumberStatusDtoConverter converter;
    private static final Logger logger = LoggerFactory.getLogger(PhoneNumberStatusService.class);

    public void createPhoneNumberStatus(final String name) {
        checkIfPhoneNumberStatusExists(name);

        phoneNumberStatusRepository.save(new PhoneNumberStatus(name));
        logger.info(LogMessage.PhoneNumberStatus.PHONE_NUMBER_STATUS_CREATED + name);
    }

    public void updatePhoneNumberStatus(final String id, final String name) {
        PhoneNumberStatus phoneNumberStatus = getPhoneNumberStatusById(id);

        if (!phoneNumberStatus.getName().equalsIgnoreCase(name)) {
            checkIfPhoneNumberStatusExists(name);
        }

        PhoneNumberStatus updatedPhoneNumberStatus = new PhoneNumberStatus(
                phoneNumberStatus.getId(),
                name,
                phoneNumberStatus.getPhoneNumbers()
        );

        phoneNumberStatusRepository.save(updatedPhoneNumberStatus);
        logger.info(LogMessage.PhoneNumberStatus.PHONE_NUMBER_STATUS_UPDATED + phoneNumberStatus.getId());
    }

    public void deletePhoneNumberStatus(final String id) {
        phoneNumberStatusRepository.delete(getPhoneNumberStatusById(id));
        logger.info(LogMessage.PhoneNumberStatus.PHONE_NUMBER_STATUS_DELETED + id);
    }

    public PhoneNumberStatusDto findPhoneNumberStatusByName(final String name) {
        PhoneNumberStatus phoneNumberStatus = phoneNumberStatusRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> {
                    logger.error(LogMessage.PhoneNumberStatus.PHONE_NUMBER_STATUS_NOT_FOUND_BY_NAME + name);
                    throw new PhoneNumberStatusNotFoundException(BusinessMessage
                            .PhoneNumberStatus.PHONE_NUMBER_STATUS_NOT_FOUND_BY_NAME + name);
                });

        logger.info(LogMessage.PhoneNumberStatus.PHONE_NUMBER_STATUS_FOUND_BY_NAME + name);
        return converter.convert(phoneNumberStatus);
    }

    public Set<PhoneNumberStatusDto> findAllPhoneNumberStatuses() {
        Set<PhoneNumberStatus> phoneNumberStatuses = new HashSet<>(phoneNumberStatusRepository.findAll());

        if (phoneNumberStatuses.isEmpty()) {
            logger.error(LogMessage.PhoneNumberStatus.PHONE_NUMBER_STATUS_LIST_EMPTY);
            throw new PhoneNumberStatusNotFoundException(BusinessMessage
                    .PhoneNumberStatus.PHONE_NUMBER_STATUS_LIST_EMPTY);
        }

        logger.info(LogMessage.PhoneNumberStatus.PHONE_NUMBER_STATUS_LIST + phoneNumberStatuses.size());
        return converter.convert(phoneNumberStatuses);
    }

    protected PhoneNumberStatus getPhoneNumberStatusById(final String id) {
        return phoneNumberStatusRepository.findById(id).orElseThrow(() -> {
            logger.error(LogMessage.PhoneNumberStatus.PHONE_NUMBER_STATUS_NOT_FOUND + id);
            throw new PhoneNumberStatusNotFoundException(BusinessMessage.PhoneNumberStatus.PHONE_NUMBER_STATUS_NOT_FOUND + id);
        });
    }

    private void checkIfPhoneNumberStatusExists(final String name) {
        if (phoneNumberStatusRepository.existsByNameIgnoreCase(name)) {
            logger.error(LogMessage.PhoneNumberStatus.PHONE_NUMBER_STATUS_ALREADY_EXISTS + name);
            throw new PhoneNumberStatusAlreadyExistException(BusinessMessage
                    .PhoneNumberStatus.PHONE_NUMBER_STATUS_ALREADY_EXISTS + name);
        }
    }

    public PhoneNumberStatusService(PhoneNumberStatusRepository phoneNumberStatusRepository,
                                    PhoneNumberStatusDtoConverter converter) {
        this.phoneNumberStatusRepository = phoneNumberStatusRepository;
        this.converter = converter;
    }
}
