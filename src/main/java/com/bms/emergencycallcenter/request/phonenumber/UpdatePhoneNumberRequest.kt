package com.bms.emergencycallcenter.request.phonenumber

import com.bms.emergencycallcenter.helper.message.ValidationMessage
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class UpdatePhoneNumberRequest(
    @NotEmpty(message = ValidationMessage.PhoneNumber.NUMBER_NOT_EMPTY)
    @NotNull(message = ValidationMessage.PhoneNumber.NUMBER_NOT_NULL)
    val number: String,

    @NotEmpty(message = ValidationMessage.PhoneNumber.NOTES_NOT_EMPTY)
    @NotNull(message = ValidationMessage.PhoneNumber.NOTES_NOT_NULL)
    val notes: String,

    @NotEmpty(message = ValidationMessage.PhoneNumber.STATUS_NOT_EMPTY)
    @NotNull(message = ValidationMessage.PhoneNumber.STATUS_NOT_NULL)
    val statusId: String,
)