package com.bms.emergencycallcenter.service;

import com.bms.emergencycallcenter.dto.OperatorDto;
import com.bms.emergencycallcenter.dto.converter.OperatorDtoConverter;
import com.bms.emergencycallcenter.exception.OperatorNotFoundException;
import com.bms.emergencycallcenter.helper.Generator;
import com.bms.emergencycallcenter.helper.message.BusinessMessage;
import com.bms.emergencycallcenter.helper.message.LogMessage;
import com.bms.emergencycallcenter.model.Operator;
import com.bms.emergencycallcenter.repository.OperatorRepository;
import com.bms.emergencycallcenter.request.operator.CreateOperatorRequest;
import com.bms.emergencycallcenter.request.operator.UpdateOperatorRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OperatorService {
    private final OperatorRepository operatorRepository;
    private final OperatorDtoConverter converter;
    private static final Logger logger = LoggerFactory.getLogger(OperatorService.class);

    public OperatorService(OperatorRepository operatorRepository,
                           OperatorDtoConverter converter) {
        this.operatorRepository = operatorRepository;
        this.converter = converter;
    }

    public void createOperator(final CreateOperatorRequest request) {
        checkIfOperatorExists(request.getFirstName(), request.getLastName());

        Operator operator = new Operator(
                Generator.generateCode(),
                request.getFirstName(),
                request.getLastName()
        );

        operatorRepository.save(operator);
        logger.info(LogMessage.Operator.OPERATOR_CREATED + operator.getId());
    }

    public void updateOperator(final String id, final UpdateOperatorRequest request) {
        Operator operator = getOperatorById(id);

        if (!operator.getFirstName().equals(request.getFirstName()) ||
                !operator.getLastName().equals(request.getLastName())) {
            checkIfOperatorExists(request.getFirstName(), request.getLastName());
        }

        Operator updatedOperator = new Operator(
                operator.getId(),
                operator.getCode(),
                request.getFirstName(),
                request.getLastName(),
                operator.getCalls()
        );

        operatorRepository.save(updatedOperator);
        logger.info(LogMessage.Operator.OPERATOR_UPDATED + operator.getId());
    }

    public void deleteOperator(final String id) {
        operatorRepository.delete(getOperatorById(id));
        logger.info(LogMessage.Operator.OPERATOR_DELETED + id);
    }

    public OperatorDto findOperatorByName(final String firstName, final String lastName) {
        Operator operator = operatorRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName)
                .orElseThrow(() -> {
                    logger.error(LogMessage.Operator.OPERATOR_NOT_FOUND_BY_NAME + firstName + " " + lastName);
                    throw new OperatorNotFoundException(BusinessMessage
                            .Operator.OPERATOR_NOT_FOUND_BY_NAME + firstName + " " + lastName);
                });

        logger.info(LogMessage.Operator.OPERATOR_FOUND_BY_NAME + firstName + " " + lastName);
        return converter.convert(operator);
    }

    public Set<OperatorDto> findAllOperators() {
        Set<Operator> operators = new HashSet<>(operatorRepository.findAll());

        if (operators.isEmpty()) {
            logger.error(LogMessage.Operator.OPERATOR_LIST_EMPTY);
            throw new OperatorNotFoundException(BusinessMessage.Operator.OPERATOR_LIST_EMPTY);
        }

        logger.info(LogMessage.Operator.OPERATOR_LIST + operators.size());
        return converter.convert(operators);
    }

    protected Operator getOperatorById(final String id) {
        return operatorRepository.findById(id).orElseThrow(() -> {
            logger.error(LogMessage.Operator.OPERATOR_NOT_FOUND + id);
            throw new OperatorNotFoundException(BusinessMessage.Operator.OPERATOR_NOT_FOUND + id);
        });
    }

    private void checkIfOperatorExists(final String firstname, final String lastName) {
        if (operatorRepository.existsByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstname, lastName)) {
            logger.error(LogMessage.Operator.OPERATOR_ALREADY_EXISTS + firstname + " " + lastName);
            throw new OperatorNotFoundException(BusinessMessage
                    .Operator.OPERATOR_ALREADY_EXISTS + firstname + " " + lastName);
        }
    }
}
