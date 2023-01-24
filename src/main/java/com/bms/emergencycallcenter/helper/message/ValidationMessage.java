package com.bms.emergencycallcenter.helper.message;

public class ValidationMessage {
    private ValidationMessage() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static class Action{
        private Action() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String NOTES_NOT_EMPTY = "Action notes can not be empty";
        public static final String NOTES_NOT_NULL = "Action notes can not be null";
        public static final String CATALOG_NOT_EMPTY = "Action catalog can not be empty";
        public static final String CATALOG_NOT_NULL = "Action catalog can not be null";
        public static final String CALL_NOT_EMPTY = "Action call can not be empty";
        public static final String CALL_NOT_NULL = "Action call can not be null";
    }

    public static class Emergency {
        private Emergency() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String NAME_NOT_EMPTY = "Emergency name can not be empty";
        public static final String NAME_NOT_NULL = "Emergency name can not be null";
        public static final String DETAILS_NOT_EMPTY = "Emergency details can not be empty";
        public static final String DETAILS_NOT_NULL = "Emergency details can not be null";
    }

    public static class Operator {
        private Operator() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String FIRST_NAME_NOT_EMPTY = "Operator first name can not be empty";
        public static final String FIRST_NAME_NOT_NULL = "Operator first name can not be null";
        public static final String LAST_NAME_NOT_EMPTY = "Operator last name can not be empty";
        public static final String LAST_NAME_NOT_NULL = "Operator last name can not be null";
    }

    public static class PhoneNumber {
        private PhoneNumber() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String NUMBER_NOT_EMPTY = "Phone number can not be empty";
        public static final String NUMBER_NOT_NULL = "Phone number can not be null";
        public static final String NOTES_NOT_EMPTY = "Phone number notes can not be empty";
        public static final String NOTES_NOT_NULL = "Phone number notes can not be null";
        public static final String STATUS_NOT_EMPTY = "Phone number status can not be empty";
        public static final String STATUS_NOT_NULL = "Phone number status can not be null";
    }

    public static class Alert {
        private Alert() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ALWAYS_ALERT_NOT_NULL = "Always alert can not be null";
        public static final String ALWAYS_ALERT_NOT_EMPTY = "Always alert can not be empty";
        public static final String EMERGENCY_NOT_NULL = "Emergency can not be null";
        public static final String EMERGENCY_NOT_EMPTY = "Emergency can not be empty";
        public static final String ACTION_CATALOG_NOT_NULL = "Action catalog can not be null";
        public static final String ACTION_CATALOG_NOT_EMPTY = "Action catalog can not be empty";
    }

    public static class Call {
        private Call() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CALL_START_TIME_NOT_NULL = "Call start time can not be null";
        public static final String CALL_START_TIME_NOT_EMPTY = "Call start time can not be empty";
        public static final String CALL_END_TIME_NOT_NULL = "Call end time can not be null";
        public static final String CALL_END_TIME_NOT_EMPTY = "Call end time can not be empty";
        public static final String CALL_STATUS_NOT_NULL = "Call status can not be null";
        public static final String CALL_STATUS_NOT_EMPTY = "Call status can not be empty";
        public static final String CALL_NOTES_NOT_NULL = "Call notes can not be null";
        public static final String CALL_NOTES_NOT_EMPTY = "Call notes can not be empty";
        public static final String CALL_OPERATOR_NOT_NULL = "Call operator can not be null";
        public static final String CALL_OPERATOR_NOT_EMPTY = "Call operator can not be empty";
        public static final String CALL_PHONE_NUMBER_NOT_NULL = "Call phone number can not be null";
        public static final String CALL_PHONE_NUMBER_NOT_EMPTY = "Call phone number can not be empty";
        public static final String CALL_CITY_NOT_NULL = "Call city can not be null";
        public static final String CALL_CITY_NOT_EMPTY = "Call city can not be empty";
    }

    public static class AlertedService {
        private AlertedService() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMERGENCY_NOT_NULL = "Emergency can not be null";
        public static final String EMERGENCY_NOT_EMPTY = "Emergency can not be empty";
        public static final String ACTION_NOT_NULL = "Action can not be null";
        public static final String ACTION_NOT_EMPTY = "Action can not be empty";
    }
}
