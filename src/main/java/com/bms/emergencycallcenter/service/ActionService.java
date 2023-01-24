package com.bms.emergencycallcenter.service;

import com.bms.emergencycallcenter.dto.ActionDto;
import com.bms.emergencycallcenter.dto.converter.ActionDtoConverter;
import com.bms.emergencycallcenter.exception.ActionNotFoundException;
import com.bms.emergencycallcenter.helper.message.BusinessMessage;
import com.bms.emergencycallcenter.helper.message.LogMessage;
import com.bms.emergencycallcenter.model.Action;
import com.bms.emergencycallcenter.repository.ActionRepository;
import com.bms.emergencycallcenter.request.action.CreateActionRequest;
import com.bms.emergencycallcenter.request.action.UpdateActionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ActionService {
    private final ActionRepository actionRepository;
    private final ActionCatalogService actionCatalogService;
    private final CallService callService;
    private final ActionDtoConverter converter;
    private static final Logger logger = LoggerFactory.getLogger(ActionService.class);

    public ActionService(ActionRepository actionRepository,
                         ActionCatalogService actionCatalogService,
                         CallService callService,
                         ActionDtoConverter converter) {
        this.actionRepository = actionRepository;
        this.actionCatalogService = actionCatalogService;
        this.callService = callService;
        this.converter = converter;
    }

    public void createAction(final CreateActionRequest request) {
        Action action = new Action(
                request.getNotes(),
                actionCatalogService.getActionCatalogById(request.getCatalogId()),
                callService.getCallById(request.getCallId())
        );

        actionRepository.save(action);
        logger.info(LogMessage.Action.ACTION_CREATED + action.getId());
    }

    public void updateAction(final String id, final UpdateActionRequest request) {
        Action action = getActionById(id);

        Action updatedAction = new Action(
                action.getId(),
                request.getNotes(),
                actionCatalogService.getActionCatalogById(request.getCatalogId()),
                action.getCall(),
                action.getAlertedService()
        );

        actionRepository.save(updatedAction);
        logger.info(LogMessage.Action.ACTION_UPDATED + updatedAction.getId());
    }

    public void deleteAction(final String id) {
        actionRepository.delete(getActionById(id));
        logger.info(LogMessage.Action.ACTION_DELETED + id);
    }

    public Set<ActionDto> findActionsByCatalogId(final String catalogId) {
        Set<Action> actions = actionRepository.findByCatalog_Id(catalogId);

        if (actions.isEmpty()) {
            logger.error(LogMessage.Action.ACTION_NOT_FOUND_BY_CATALOG_ID + catalogId);
            throw new ActionNotFoundException(BusinessMessage.Action.ACTION_NOT_FOUND_BY_CATALOG_ID + catalogId);
        }

        logger.info(LogMessage.Action.ACTIONS_FOUND_BY_CATALOG_ID + catalogId);
        return converter.convert(actions);
    }

    public Set<ActionDto> findActionsByCallId(final String callId) {
        Set<Action> actions = actionRepository.findByCall_Id(callId);

        if (actions.isEmpty()) {
            logger.error(LogMessage.Action.ACTION_NOT_FOUND_BY_CALL_ID + callId);
            throw new ActionNotFoundException(BusinessMessage.Action.ACTION_NOT_FOUND_BY_CALL_ID + callId);
        }

        logger.info(LogMessage.Action.ACTIONS_FOUND_BY_CALL_ID + callId);
        return converter.convert(actions);
    }

    public Set<ActionDto> findAllActions() {
        Set<Action> actions = new HashSet<>(actionRepository.findAll());

        if (actions.isEmpty()) {
            logger.error(LogMessage.Action.ACTION_LIST_EMPTY);
            throw new ActionNotFoundException(BusinessMessage.Action.ACTION_LIST_EMPTY);
        }

        logger.info(LogMessage.Action.ACTION_LIST + actions.size());
        return converter.convert(actions);
    }

    protected Action getActionById(final String id) {
        return actionRepository.findById(id).orElseThrow(() -> {
            logger.error(LogMessage.Action.ACTION_NOT_FOUND + id);
            throw new ActionNotFoundException(BusinessMessage.Action.ACTION_NOT_FOUND + id);
        });
    }
}