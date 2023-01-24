package com.bms.emergencycallcenter.service;

import com.bms.emergencycallcenter.dto.ActionCatalogDto;
import com.bms.emergencycallcenter.dto.converter.ActionCatalogDtoConverter;
import com.bms.emergencycallcenter.exception.ActionCatalogAlreadyExistException;
import com.bms.emergencycallcenter.exception.ActionCatalogNotFoundException;
import com.bms.emergencycallcenter.helper.message.BusinessMessage;
import com.bms.emergencycallcenter.helper.message.LogMessage;
import com.bms.emergencycallcenter.model.ActionCatalog;
import com.bms.emergencycallcenter.repository.ActionCatalogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ActionCatalogService {
    private final ActionCatalogRepository actionCatalogRepository;
    private final ActionCatalogDtoConverter converter;
    private static final Logger logger = LoggerFactory.getLogger(ActionCatalogService.class);

    public ActionCatalogService(ActionCatalogRepository actionCatalogRepository,
                                ActionCatalogDtoConverter converter) {
        this.actionCatalogRepository = actionCatalogRepository;
        this.converter = converter;
    }

    public void createActionCatalog(final String name) {
        checkIfActionCatalogExist(name);

        actionCatalogRepository.save(new ActionCatalog(name));
        logger.info(LogMessage.ActionCatalog.ACTION_CATALOG_CREATED + name);
    }

    public void updateActionCatalog(final String id, final String name) {
        ActionCatalog actionCatalog = getActionCatalogById(id);

        if (!actionCatalog.getName().equalsIgnoreCase(name)) {
            checkIfActionCatalogExist(name);
        }

        ActionCatalog updatedActionCatalog = new ActionCatalog(
                actionCatalog.getId(),
                name,
                actionCatalog.getAlerts(),
                actionCatalog.getActions()
        );

        actionCatalogRepository.save(updatedActionCatalog);
        logger.info(LogMessage.ActionCatalog.ACTION_CATALOG_UPDATED + actionCatalog.getId());
    }

    public void deleteActionCatalog(final String id) {
        actionCatalogRepository.delete(getActionCatalogById(id));
        logger.info(LogMessage.ActionCatalog.ACTION_CATALOG_DELETED + id);
    }

    public ActionCatalogDto findActionCatalogByName(final String name) {
        ActionCatalog actionCatalog = actionCatalogRepository.findByNameIgnoreCase(name).orElseThrow(() -> {
            logger.error(LogMessage.ActionCatalog.ACTION_CATALOG_NOT_FOUND_BY_NAME + name);
            throw new ActionCatalogNotFoundException(BusinessMessage.
                    ActionCatalog.ACTION_CATALOG_NOT_FOUND_BY_NAME + name);
        });

        logger.info(LogMessage.ActionCatalog.ACTION_CATALOG_FOUND_BY_NAME + name);
        return converter.convert(actionCatalog);
    }

    public Set<ActionCatalogDto> findAllActionCatalogs() {
        Set<ActionCatalog> actionCatalogs = new HashSet<>(actionCatalogRepository.findAll());

        if (actionCatalogs.isEmpty()) {
            logger.error(LogMessage.ActionCatalog.ACTION_CATALOG_LIST_EMPTY);
            throw new ActionCatalogNotFoundException(BusinessMessage.ActionCatalog.ACTION_CATALOG_LIST_EMPTY);
        }

        logger.info(LogMessage.ActionCatalog.ACTION_CATALOG_LIST + actionCatalogs.size());
        return converter.convert(actionCatalogs);
    }

    protected ActionCatalog getActionCatalogById(final String id) {
        return actionCatalogRepository.findById(id).orElseThrow(() -> {
            logger.error(LogMessage.ActionCatalog.ACTION_CATALOG_NOT_FOUND + id);
            throw new ActionCatalogNotFoundException(BusinessMessage.ActionCatalog.ACTION_CATALOG_NOT_FOUND + id);
        });
    }

    private void checkIfActionCatalogExist(final String name) {
        if (actionCatalogRepository.existsByNameIgnoreCase(name)) {
            logger.error(LogMessage.ActionCatalog.ACTION_CATALOG_ALREADY_EXIST + name);
            throw new ActionCatalogAlreadyExistException(BusinessMessage
                    .ActionCatalog.ACTION_CATALOG_ALREADY_EXIST + name);
        }
    }
}
