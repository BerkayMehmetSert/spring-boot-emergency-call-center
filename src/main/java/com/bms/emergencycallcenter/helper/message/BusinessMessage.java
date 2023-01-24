package com.bms.emergencycallcenter.helper.message;

public class BusinessMessage {
    public static final String ILLEGAL_STATE_EXCEPTION = "Utility class, can not be instantiated";

    private BusinessMessage() {
        throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
    }

    public static class Action {
        private Action() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ACTION_NOT_FOUND = "Action not found with id: ";
        public static final String ACTION_NOT_FOUND_BY_CALL_ID = "Action not found with call id: ";
        public static final String ACTION_NOT_FOUND_BY_CATALOG_ID = "Action not found with catalog id: ";
        public static final String ACTION_LIST_EMPTY = "Action list is empty";

    }

    public static class ActionCatalog {
        private ActionCatalog() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ACTION_CATALOG_NOT_FOUND = "Action catalog not found with id: ";
        public static final String ACTION_CATALOG_NOT_FOUND_BY_NAME = "Action catalog not found with name: ";
        public static final String ACTION_CATALOG_LIST_EMPTY = "Action catalog list is empty";
        public static final String ACTION_CATALOG_ALREADY_EXIST = "Action catalog already exist with name: ";
    }

    public static class Alert {
        private Alert() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ALERT_NOT_FOUND = "Alert not found with id: ";
        public static final String ALERT_NOT_FOUND_BY_EMERGENCY_ID = "Alert not found with emergency id: ";
        public static final String ALERT_NOT_FOUND_BY_CATALOG_ID = "Alert not found with catalog id: ";
        public static final String ALERT_LIST_EMPTY = "Alert list is empty";
    }

    public static class AlertedService {
        private AlertedService() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ALERTED_SERVICE_NOT_FOUND = "Alerted service not found with id: ";
        public static final String ALERTED_SERVICE_NOT_FOUND_BY_ACTION_ID = "Alerted service not found with action id: ";
        public static final String ALERTED_SERVICE_NOT_FOUND_BY_EMERGENCY_ID = "Alerted service not found with emergency id: ";
        public static final String ALERTED_SERVICE_LIST_EMPTY = "Alerted service list is empty";
    }

    public static class Call {
        private Call() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CALL_NOT_FOUND = "Call not found with id: ";
        public static final String CALL_NOT_FOUND_BY_OPERATOR_ID = "Call not found with operator id: ";
        public static final String CALL_NOT_FOUND_BY_PHONE_NUMBER = "Call not found with phone number: ";
        public static final String CALL_NOT_FOUND_BY_STATUS = "Call not found with status: ";
        public static final String CALL_NOT_FOUND_BY_CITY = "Call not found with city: ";
        public static final String CALL_LIST_EMPTY = "Call list is empty";
    }

    public static class CallStatus {
        private CallStatus() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CALL_STATUS_NOT_FOUND = "Call status not found with id: ";
        public static final String CALL_STATUS_NOT_FOUND_BY_NAME = "Call status not found with name: ";
        public static final String CALL_STATUS_LIST_EMPTY = "Call status list is empty";
        public static final String CALL_STATUS_ALREADY_EXISTS = "Call status already exists with name: ";
    }

    public static class City {
        private City() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CITY_NOT_FOUND = "City not found with id: ";
        public static final String CITY_NOT_FOUND_BY_NAME = "City not found with name: ";
        public static final String CITY_LIST_EMPTY = "City list is empty";
        public static final String CITY_ALREADY_EXISTS = "City already exists with name: ";
    }

    public static class Country {
        private Country() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String COUNTRY_NOT_FOUND = "Country not found with id: ";
        public static final String COUNTRY_NOT_FOUND_BY_NAME = "Country not found with name: ";
        public static final String COUNTRY_LIST_EMPTY = "Country list is empty";
        public static final String COUNTRY_ALREADY_EXISTS = "Country already exists with name: ";
    }

    public static class Emergency {
        private Emergency() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMERGENCY_NOT_FOUND = "Emergency not found with id: ";
        public static final String EMERGENCY_NOT_FOUND_BY_NAME = "Emergency not found with name: ";
        public static final String EMERGENCY_LIST_EMPTY = "Emergency list is empty";
        public static final String EMERGENCY_ALREADY_EXISTS = "Emergency already exists with name: ";
    }

    public static class Operator {
        private Operator() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String OPERATOR_NOT_FOUND = "Operator not found with id: ";
        public static final String OPERATOR_NOT_FOUND_BY_NAME = "Operator not found with name: ";
        public static final String OPERATOR_LIST_EMPTY = "Operator list is empty";
        public static final String OPERATOR_ALREADY_EXISTS = "Operator already exists with name: ";
    }

    public static class PhoneNumber {
        private PhoneNumber() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PHONE_NUMBER_NOT_FOUND = "Phone number not found with id: ";
        public static final String PHONE_NUMBER_NOT_FOUND_BY_NUMBER = "Phone number not found with number: ";
        public static final String PHONE_NUMBER_LIST_EMPTY = "Phone number list is empty";
        public static final String PHONE_NUMBER_ALREADY_EXISTS = "Phone number already exists with number: ";
    }

    public static class PhoneNumberStatus {
        private PhoneNumberStatus() {
            throw new IllegalStateException(ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PHONE_NUMBER_STATUS_NOT_FOUND = "Phone number status not found with id: ";
        public static final String PHONE_NUMBER_STATUS_NOT_FOUND_BY_NAME = "Phone number status not found with name: ";
        public static final String PHONE_NUMBER_STATUS_LIST_EMPTY = "Phone number status list is empty";
        public static final String PHONE_NUMBER_STATUS_ALREADY_EXISTS = "Phone number status already exists with name: ";
    }
}
