package com.bms.emergencycallcenter.service;

import com.bms.emergencycallcenter.dto.EmergencyDto;
import com.bms.emergencycallcenter.dto.converter.EmergencyDtoConverter;
import com.bms.emergencycallcenter.exception.EmergencyAlreadyExistException;
import com.bms.emergencycallcenter.exception.EmergencyNotFoundException;
import com.bms.emergencycallcenter.helper.message.BusinessMessage;
import com.bms.emergencycallcenter.helper.message.LogMessage;
import com.bms.emergencycallcenter.model.Emergency;
import com.bms.emergencycallcenter.repository.EmergencyRepository;
import com.bms.emergencycallcenter.request.emergency.CreateEmergencyRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class EmergencyService {
    private final EmergencyRepository emergencyRepository;
    private final EmergencyDtoConverter converter;
    private static final Logger logger = LoggerFactory.getLogger(EmergencyService.class);

    public EmergencyService(EmergencyRepository emergencyRepository,
                            EmergencyDtoConverter converter) {
        this.emergencyRepository = emergencyRepository;
        this.converter = converter;
    }

    public void createEmergency(final CreateEmergencyRequest request) {
        checkIfEmergencyExists(request.getName());

        Emergency emergency = new Emergency(
                request.getName(),
                request.getDetails()
        );

        emergencyRepository.save(emergency);
        logger.info(LogMessage.Emergency.EMERGENCY_CREATED + emergency.getId());
    }

    public void updateEmergencyName(final String id, final String name) {
        Emergency emergency = getEmergencyById(id);

        if (!emergency.getName().equalsIgnoreCase(name)) {
            checkIfEmergencyExists(name);
        }

        Emergency updatedEmergency = new Emergency(
                emergency.getId(),
                name,
                emergency.getDetails(),
                emergency.getAlertedService(),
                emergency.getAlert()
        );

        emergencyRepository.save(updatedEmergency);
        logger.info(LogMessage.Emergency.EMERGENCY_UPDATED + emergency.getId());
    }

    public void updateEmergencyDetails(final String id, final String details) {
        Emergency emergency = getEmergencyById(id);

        Emergency updatedEmergency = new Emergency(
                emergency.getId(),
                emergency.getName(),
                details,
                emergency.getAlertedService(),
                emergency.getAlert()
        );

        emergencyRepository.save(updatedEmergency);
        logger.info(LogMessage.Emergency.EMERGENCY_UPDATED + emergency.getId());
    }

    public void deleteEmergency(final String id) {
        emergencyRepository.delete(getEmergencyById(id));
        logger.info(LogMessage.Emergency.EMERGENCY_DELETED + id);
    }

    public EmergencyDto findEmergencyByName(final String name) {
        Emergency emergency = emergencyRepository.findByNameIgnoreCase(name).orElseThrow(() -> {
            logger.error(LogMessage.Emergency.EMERGENCY_NOT_FOUND_BY_NAME + name);
            throw new EmergencyNotFoundException(BusinessMessage.Emergency.EMERGENCY_NOT_FOUND_BY_NAME + name);
        });

        logger.info(LogMessage.Emergency.EMERGENCY_FOUND_BY_NAME + name);
        return converter.convert(emergency);
    }

    public Set<EmergencyDto> findAllEmergencies() {
        Set<Emergency> emergencies = new HashSet<>(emergencyRepository.findAll());

        if (emergencies.isEmpty()) {
            logger.error(LogMessage.Emergency.EMERGENCY_LIST_EMPTY);
            throw new EmergencyNotFoundException(BusinessMessage.Emergency.EMERGENCY_LIST_EMPTY);
        }

        logger.info(LogMessage.Emergency.EMERGENCY_LIST + emergencies.size());
        return converter.convert(emergencies);
    }

    protected Emergency getEmergencyById(final String id) {
        return emergencyRepository.findById(id).orElseThrow(() -> {
            logger.error(LogMessage.Emergency.EMERGENCY_NOT_FOUND + id);
            throw new EmergencyNotFoundException(BusinessMessage.Emergency.EMERGENCY_NOT_FOUND + id);
        });
    }

    private void checkIfEmergencyExists(final String name) {
        if (emergencyRepository.existsByNameIgnoreCase(name)) {
            logger.error(LogMessage.Emergency.EMERGENCY_ALREADY_EXISTS + name);
            throw new EmergencyAlreadyExistException(BusinessMessage.Emergency.EMERGENCY_ALREADY_EXISTS + name);
        }
    }
}
