package com.bms.emergencycallcenter.request.alertedservice

import com.bms.emergencycallcenter.helper.message.ValidationMessage
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateAlertedServiceRequest(
    @NotEmpty(message = ValidationMessage.AlertedService.EMERGENCY_NOT_EMPTY)
    @NotNull(message = ValidationMessage.AlertedService.EMERGENCY_NOT_NULL)
    val emergencyId:String,

    @NotEmpty(message = ValidationMessage.AlertedService.ACTION_NOT_EMPTY)
    @NotNull(message = ValidationMessage.AlertedService.ACTION_NOT_NULL)
    val actionId:String
)
