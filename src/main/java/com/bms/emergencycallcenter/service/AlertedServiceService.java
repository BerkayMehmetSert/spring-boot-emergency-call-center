package com.bms.emergencycallcenter.service;

import com.bms.emergencycallcenter.dto.AlertedServiceDto;
import com.bms.emergencycallcenter.dto.converter.AlertedServiceDtoConverter;
import com.bms.emergencycallcenter.exception.AlertedServiceNotFoundException;
import com.bms.emergencycallcenter.helper.message.BusinessMessage;
import com.bms.emergencycallcenter.helper.message.LogMessage;
import com.bms.emergencycallcenter.model.AlertedService;
import com.bms.emergencycallcenter.repository.AlertedServiceRepository;
import com.bms.emergencycallcenter.request.alertedservice.CreateAlertedServiceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AlertedServiceService {
    private final AlertedServiceRepository alertedServiceRepository;
    private final EmergencyService emergencyService;
    private final ActionService actionService;
    private final AlertedServiceDtoConverter converter;
    private static final Logger logger = LoggerFactory.getLogger(AlertedServiceService.class);

    public AlertedServiceService(AlertedServiceRepository alertedServiceRepository,
                                 EmergencyService emergencyService,
                                 ActionService actionService,
                                 AlertedServiceDtoConverter converter) {
        this.alertedServiceRepository = alertedServiceRepository;
        this.emergencyService = emergencyService;
        this.actionService = actionService;
        this.converter = converter;
    }

    public void createAlertedService(final CreateAlertedServiceRequest request) {
        AlertedService alertedService = new AlertedService(
                emergencyService.getEmergencyById(request.getEmergencyId()),
                actionService.getActionById(request.getActionId())
        );

        alertedServiceRepository.save(alertedService);
        logger.info(LogMessage.AlertedService.ALERTED_SERVICE_CREATED + alertedService.getId());
    }

    public void deleteAlertedService(final String id) {
        alertedServiceRepository.delete(getAlertedServiceById(id));
        logger.info(LogMessage.AlertedService.ALERTED_SERVICE_DELETED + id);
    }

    public Set<AlertedServiceDto> findAlertedServicesByEmergencyId(final String emergencyId) {
        Set<AlertedService> alertedServices = alertedServiceRepository.findByEmergency_Id(emergencyId);

        if (alertedServices.isEmpty()) {
            logger.error(LogMessage.AlertedService.ALERTED_SERVICE_NOT_FOUND_BY_EMERGENCY_ID + emergencyId);
            throw new AlertedServiceNotFoundException(BusinessMessage
                    .AlertedService.ALERTED_SERVICE_NOT_FOUND_BY_EMERGENCY_ID + emergencyId);
        }

        logger.info(LogMessage.AlertedService.ALERTED_SERVICES_FOUND_BY_EMERGENCY_ID + emergencyId);
        return converter.convert(alertedServices);
    }

    public Set<AlertedServiceDto> findAlertedServicesByActionId(final String actionId) {
        Set<AlertedService> alertedServices = alertedServiceRepository.findByAction_Id(actionId);

        if (alertedServices.isEmpty()) {
            logger.error(LogMessage.AlertedService.ALERTED_SERVICE_NOT_FOUND_BY_ACTION_ID + actionId);
            throw new AlertedServiceNotFoundException(BusinessMessage
                    .AlertedService.ALERTED_SERVICE_NOT_FOUND_BY_ACTION_ID + actionId);
        }

        logger.info(LogMessage.AlertedService.ALERTED_SERVICES_FOUND_BY_ACTION_ID + actionId);
        return converter.convert(alertedServices);
    }

    public Set<AlertedServiceDto> findAllAlertedServices() {
        Set<AlertedService> alertedServices = new HashSet<>(alertedServiceRepository.findAll());

        if (alertedServices.isEmpty()) {
            logger.error(LogMessage.AlertedService.ALERTED_SERVICE_LIST_EMPTY);
            throw new AlertedServiceNotFoundException(BusinessMessage
                    .AlertedService.ALERTED_SERVICE_LIST_EMPTY);
        }

        logger.info(LogMessage.AlertedService.ALERTED_SERVICE_LIST + alertedServices.size());
        return converter.convert(alertedServices);
    }

    private AlertedService getAlertedServiceById(final String id) {
        return alertedServiceRepository.findById(id).orElseThrow(() -> {
            logger.error(LogMessage.AlertedService.ALERTED_SERVICE_NOT_FOUND + id);
            throw new AlertedServiceNotFoundException(BusinessMessage
                    .AlertedService.ALERTED_SERVICE_NOT_FOUND + id);
        });
    }
}
