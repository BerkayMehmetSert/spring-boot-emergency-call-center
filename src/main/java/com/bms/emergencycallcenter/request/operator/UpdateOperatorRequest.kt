package com.bms.emergencycallcenter.request.operator

import com.bms.emergencycallcenter.helper.message.ValidationMessage
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class UpdateOperatorRequest(
    @NotEmpty(message = ValidationMessage.Operator.FIRST_NAME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Operator.FIRST_NAME_NOT_NULL)
    val firstName: String,

    @NotEmpty(message = ValidationMessage.Operator.LAST_NAME_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Operator.LAST_NAME_NOT_NULL)
    val lastName: String
)
