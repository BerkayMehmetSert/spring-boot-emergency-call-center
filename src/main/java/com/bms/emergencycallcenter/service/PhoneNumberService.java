package com.bms.emergencycallcenter.service;

import com.bms.emergencycallcenter.dto.PhoneNumberDto;
import com.bms.emergencycallcenter.dto.converter.PhoneNumberDtoConverter;
import com.bms.emergencycallcenter.exception.PhoneNumberAlreadyExistException;
import com.bms.emergencycallcenter.exception.PhoneNumberNotFoundException;
import com.bms.emergencycallcenter.helper.message.BusinessMessage;
import com.bms.emergencycallcenter.helper.message.LogMessage;
import com.bms.emergencycallcenter.model.PhoneNumber;
import com.bms.emergencycallcenter.repository.PhoneNumberRepository;
import com.bms.emergencycallcenter.request.phonenumber.CreatePhoneNumberRequest;
import com.bms.emergencycallcenter.request.phonenumber.UpdatePhoneNumberRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PhoneNumberService {
    private final PhoneNumberRepository phoneNumberRepository;
    private final PhoneNumberStatusService phoneNumberStatusService;
    private final PhoneNumberDtoConverter converter;
    private static final Logger logger = LoggerFactory.getLogger(PhoneNumberService.class);

    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository,
                              PhoneNumberStatusService phoneNumberStatusService,
                              PhoneNumberDtoConverter converter) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.phoneNumberStatusService = phoneNumberStatusService;
        this.converter = converter;
    }

    public void createPhoneNumber(final CreatePhoneNumberRequest request) {
        checkIfPhoneNumberExists(request.getNumber());

        PhoneNumber phoneNumber = new PhoneNumber(
                request.getNumber(),
                request.getNotes(),
                phoneNumberStatusService.getPhoneNumberStatusById(request.getStatusId())
        );

        phoneNumberRepository.save(phoneNumber);
        logger.info(LogMessage.PhoneNumber.PHONE_NUMBER_CREATED + phoneNumber.getId());
    }

    public void updatePhoneNumber(final String id, final UpdatePhoneNumberRequest request) {
        PhoneNumber phoneNumber = getPhoneNumberById(id);

        if (!phoneNumber.getNumber().equals(request.getNumber())) {
            checkIfPhoneNumberExists(request.getNumber());
        }

        PhoneNumber updatedPhoneNumber = new PhoneNumber(
                phoneNumber.getId(),
                request.getNumber(),
                request.getNotes(),
                phoneNumberStatusService.getPhoneNumberStatusById(request.getStatusId()),
                phoneNumber.getCalls()
        );

        phoneNumberRepository.save(updatedPhoneNumber);
        logger.info(LogMessage.PhoneNumber.PHONE_NUMBER_UPDATED + phoneNumber.getId());
    }

    public void deletePhoneNumber(final String id) {
        phoneNumberRepository.delete(getPhoneNumberById(id));
        logger.info(LogMessage.PhoneNumber.PHONE_NUMBER_DELETED + id);
    }

    public PhoneNumberDto findPhoneNumberByNumber(final String number) {
        PhoneNumber phoneNumber = phoneNumberRepository.findByNumber(number).orElseThrow(() -> {
            logger.error(LogMessage.PhoneNumber.PHONE_NUMBER_NOT_FOUND_BY_NUMBER + number);
            throw new PhoneNumberNotFoundException(BusinessMessage
                    .PhoneNumber.PHONE_NUMBER_NOT_FOUND_BY_NUMBER + number);
        });

        logger.info(LogMessage.PhoneNumber.PHONE_NUMBER_FOUND_BY_NUMBER + number);
        return converter.convert(phoneNumber);
    }

    public Set<PhoneNumberDto> findAllPhoneNumbers() {
        Set<PhoneNumber> phoneNumbers = new HashSet<>(phoneNumberRepository.findAll());

        if (phoneNumbers.isEmpty()) {
            logger.error(LogMessage.PhoneNumber.PHONE_NUMBER_LIST_EMPTY);
            throw new PhoneNumberNotFoundException(BusinessMessage.PhoneNumber.PHONE_NUMBER_LIST_EMPTY);
        }

        logger.info(LogMessage.PhoneNumber.PHONE_NUMBER_LIST + phoneNumbers.size());
        return converter.convert(phoneNumbers);
    }

    protected PhoneNumber getPhoneNumberById(final String id) {
        return phoneNumberRepository.findById(id).orElseThrow(() -> {
            logger.error(LogMessage.PhoneNumber.PHONE_NUMBER_NOT_FOUND + id);
            throw new PhoneNumberNotFoundException(BusinessMessage.PhoneNumber.PHONE_NUMBER_NOT_FOUND + id);
        });
    }

    private void checkIfPhoneNumberExists(final String number) {
        if (phoneNumberRepository.existsByNumber(number)) {
            logger.error(LogMessage.PhoneNumber.PHONE_NUMBER_ALREADY_EXISTS + number);
            throw new PhoneNumberAlreadyExistException(BusinessMessage
                    .PhoneNumber.PHONE_NUMBER_ALREADY_EXISTS + number);
        }
    }
}
