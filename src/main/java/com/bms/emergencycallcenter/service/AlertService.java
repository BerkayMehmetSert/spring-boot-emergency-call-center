package com.bms.emergencycallcenter.service;

import com.bms.emergencycallcenter.dto.AlertDto;
import com.bms.emergencycallcenter.dto.converter.AlertDtoConverter;
import com.bms.emergencycallcenter.exception.AlertNotFoundException;
import com.bms.emergencycallcenter.helper.message.BusinessMessage;
import com.bms.emergencycallcenter.helper.message.LogMessage;
import com.bms.emergencycallcenter.model.Alert;
import com.bms.emergencycallcenter.repository.AlertRepository;
import com.bms.emergencycallcenter.request.alert.CreateAlertRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AlertService {
    private final AlertRepository alertRepository;
    private final EmergencyService emergencyService;
    private final ActionCatalogService actionCatalogService;
    private final AlertDtoConverter converter;
    private static final Logger logger = LoggerFactory.getLogger(AlertService.class);

    public AlertService(AlertRepository alertRepository,
                        EmergencyService emergencyService,
                        ActionCatalogService actionCatalogService,
                        AlertDtoConverter converter) {
        this.alertRepository = alertRepository;
        this.emergencyService = emergencyService;
        this.actionCatalogService = actionCatalogService;
        this.converter = converter;
    }

    public void createAlert(final CreateAlertRequest request) {
        Alert alert = new Alert(
                request.getAlwaysAlert(),
                emergencyService.getEmergencyById(request.getEmergencyId()),
                actionCatalogService.getActionCatalogById(request.getCatalogId())
        );

        alertRepository.save(alert);
        logger.info(LogMessage.Alert.ALERT_CREATED + alert.getId());
    }

    public void updateAlert(final String id, final Boolean alwaysAlert) {
        Alert alert = getAlertById(id);

        Alert updatedAlert = new Alert(
                alert.getId(),
                alwaysAlert,
                alert.getEmergency(),
                alert.getCatalog()
        );

        alertRepository.save(updatedAlert);
        logger.info(LogMessage.Alert.ALERT_UPDATED + alert.getId());
    }

    public void updateAlertEmergency(final String id, final String emergencyId) {
        Alert alert = getAlertById(id);

        Alert updatedAlert = new Alert(
                alert.getId(),
                alert.getAlwaysAlert(),
                emergencyService.getEmergencyById(emergencyId),
                alert.getCatalog()
        );

        alertRepository.save(updatedAlert);
        logger.info(LogMessage.Alert.ALERT_UPDATED + alert.getId());
    }

    public void updateAlertCatalog(final String id, final String catalogId) {
        Alert alert = getAlertById(id);

        Alert updatedAlert = new Alert(
                alert.getId(),
                alert.getAlwaysAlert(),
                alert.getEmergency(),
                actionCatalogService.getActionCatalogById(catalogId)
        );

        alertRepository.save(updatedAlert);
        logger.info(LogMessage.Alert.ALERT_UPDATED + alert.getId());
    }

    public void deleteAlert(final String id) {
        alertRepository.delete(getAlertById(id));
        logger.info(LogMessage.Alert.ALERT_DELETED + id);
    }

    public AlertDto findAlertById(final String id) {
        logger.info(LogMessage.Alert.ALERT_FOUND + id);
        return converter.convert(getAlertById(id));
    }

    public Set<AlertDto> findAlertsByEmergencyId(final String emergencyId) {
        Set<Alert> alerts = alertRepository.findByEmergency_Id(emergencyId);

        if (alerts.isEmpty()) {
            logger.error(LogMessage.Alert.ALERT_NOT_FOUND_BY_EMERGENCY_ID + emergencyId);
            throw new AlertNotFoundException(BusinessMessage.Alert.ALERT_NOT_FOUND_BY_EMERGENCY_ID + emergencyId);
        }

        logger.info(LogMessage.Alert.ALERT_FOUND_BY_EMERGENCY_ID + emergencyId);
        return converter.convert(alerts);
    }

    public Set<AlertDto> findAlertsByCatalogId(final String catalogId) {
        Set<Alert> alerts = alertRepository.findByCatalog_Id(catalogId);

        if (alerts.isEmpty()) {
            logger.error(LogMessage.Alert.ALERT_NOT_FOUND_BY_CATALOG_ID + catalogId);
            throw new AlertNotFoundException(BusinessMessage.Alert.ALERT_NOT_FOUND_BY_CATALOG_ID + catalogId);
        }

        logger.info(LogMessage.Alert.ALERT_FOUND_BY_CATALOG_ID + catalogId);
        return converter.convert(alerts);
    }

    public Set<AlertDto> findAllAlerts() {
        Set<Alert> alerts = new HashSet<>(alertRepository.findAll());

        if (alerts.isEmpty()) {
            logger.error(LogMessage.Alert.ALERT_LIST_EMPTY);
            throw new AlertNotFoundException(BusinessMessage.Alert.ALERT_LIST_EMPTY);
        }

        logger.info(LogMessage.Alert.ALERT_LIST + alerts.size());
        return converter.convert(alerts);
    }

    protected Alert getAlertById(final String id) {
        return alertRepository.findById(id).orElseThrow(() -> {
            logger.error(LogMessage.Alert.ALERT_NOT_FOUND + id);
            throw new AlertNotFoundException(BusinessMessage.Alert.ALERT_NOT_FOUND + id);
        });
    }
}
