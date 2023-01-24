package com.bms.emergencycallcenter.request.emergency

import com.bms.emergencycallcenter.helper.message.ValidationMessage
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateEmergencyRequest(
    @NotEmpty(message = ValidationMessage.Emergency.NAME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Emergency.NAME_NOT_NULL)
    val name: String,

    @NotEmpty(message = ValidationMessage.Emergency.DETAILS_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Emergency.DETAILS_NOT_NULL)
    val details: String
)