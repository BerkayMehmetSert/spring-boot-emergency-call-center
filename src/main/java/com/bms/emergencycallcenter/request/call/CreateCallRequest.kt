package com.bms.emergencycallcenter.request.call

import com.bms.emergencycallcenter.helper.message.ValidationMessage
import java.time.LocalDateTime
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateCallRequest(
    @NotEmpty(message = ValidationMessage.Call.CALL_START_TIME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Call.CALL_START_TIME_NOT_NULL)
    val callStartTime: LocalDateTime,

    @NotEmpty(message = ValidationMessage.Call.CALL_END_TIME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Call.CALL_END_TIME_NOT_NULL)
    val callEndTime: LocalDateTime,

    @NotEmpty(message = ValidationMessage.Call.CALL_NOTES_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Call.CALL_NOTES_NOT_NULL)
    val notes: String,

    @NotEmpty(message = ValidationMessage.Call.CALL_OPERATOR_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Call.CALL_OPERATOR_NOT_NULL)
    val operatorId: String,

    @NotEmpty(message = ValidationMessage.Call.CALL_PHONE_NUMBER_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Call.CALL_PHONE_NUMBER_NOT_NULL)
    val phoneNumberId: String,

    @NotEmpty(message = ValidationMessage.Call.CALL_STATUS_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Call.CALL_STATUS_NOT_NULL)
    val callStatusId: String,

    @NotEmpty(message = ValidationMessage.Call.CALL_CITY_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Call.CALL_CITY_NOT_NULL)
    val cityId: String
)
