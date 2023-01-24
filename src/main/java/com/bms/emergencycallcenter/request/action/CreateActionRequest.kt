package com.bms.emergencycallcenter.request.action

import com.bms.emergencycallcenter.helper.message.ValidationMessage
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateActionRequest(
    @NotEmpty(message = ValidationMessage.Action.NOTES_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Action.NOTES_NOT_NULL)
    val notes: String,

    @NotEmpty(message = ValidationMessage.Action.CATALOG_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Action.CATALOG_NOT_NULL)
    val catalogId: String,

    @NotEmpty(message = ValidationMessage.Action.CALL_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Action.CALL_NOT_NULL)
    val callId: String
)
