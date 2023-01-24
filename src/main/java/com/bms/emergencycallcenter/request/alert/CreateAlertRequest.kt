package com.bms.emergencycallcenter.request.alert

import com.bms.emergencycallcenter.helper.message.ValidationMessage
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateAlertRequest(
    @NotEmpty(message = ValidationMessage.Alert.ALWAYS_ALERT_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Alert.ALWAYS_ALERT_NOT_NULL)
    val alwaysAlert: Boolean,

    @NotEmpty(message = ValidationMessage.Alert.EMERGENCY_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Alert.EMERGENCY_NOT_NULL)
    val emergencyId: String,

    @NotEmpty(message = ValidationMessage.Alert.ACTION_CATALOG_NOT_EMPTY)
    @NotNull(message = ValidationMessage.Alert.ACTION_CATALOG_NOT_NULL)
    val catalogId: String
)
