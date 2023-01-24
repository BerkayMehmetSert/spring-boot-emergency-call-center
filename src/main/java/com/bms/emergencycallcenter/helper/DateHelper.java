package com.bms.emergencycallcenter.helper;

import com.bms.emergencycallcenter.helper.message.BusinessMessage;

import java.time.LocalDateTime;

public class DateHelper {
    private DateHelper() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static LocalDateTime getCurrentDate() {
        return LocalDateTime.now();
    }
}
