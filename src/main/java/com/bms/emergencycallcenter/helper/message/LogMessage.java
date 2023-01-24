package com.bms.emergencycallcenter.helper.message;

public class LogMessage {
    private LogMessage() {
        throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
    }

    public static class Action {
        private Action() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ACTION_NOT_FOUND = "Action not found with id: ";
        public static final String ACTION_NOT_FOUND_BY_CALL_ID = "Action not found with call id: ";
        public static final String ACTION_NOT_FOUND_BY_CATALOG_ID = "Action not found with catalog id: ";
        public static final String ACTION_LIST_EMPTY = "Action list is empty";
        public static final String ACTION_CREATED = "Action created successfully with id: ";
        public static final String ACTION_UPDATED = "Action updated successfully with id: ";
        public static final String ACTION_DELETED = "Action deleted successfully with id: ";
        public static final String ACTION_LIST = "Action list retrieved successfully, size: ";
        public static final String ACTIONS_FOUND_BY_CATALOG_ID = "Actions found with catalog id: ";
        public static final String ACTIONS_FOUND_BY_CALL_ID = "Actions found with call id: ";
    }

    public static class ActionCatalog {
        private ActionCatalog() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ACTION_CATALOG_NOT_FOUND = "Action catalog not found with id: ";
        public static final String ACTION_CATALOG_NOT_FOUND_BY_NAME = "Action catalog not found with name: ";
        public static final String ACTION_CATALOG_LIST_EMPTY = "Action catalog list is empty";
        public static final String ACTION_CATALOG_CREATED = "Action catalog created successfully with name: ";
        public static final String ACTION_CATALOG_UPDATED = "Action catalog updated successfully with id: ";
        public static final String ACTION_CATALOG_DELETED = "Action catalog deleted successfully with id: ";
        public static final String ACTION_CATALOG_LIST = "Action catalog list retrieved successfully, size: ";
        public static final String ACTION_CATALOG_ALREADY_EXIST = "Action catalog already exist with name: ";
        public static final String ACTION_CATALOG_FOUND_BY_NAME = "Action catalog found with name: ";
    }

    public static class Alert {
        private Alert() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ALERT_NOT_FOUND = "Alert not found with id: ";
        public static final String ALERT_NOT_FOUND_BY_EMERGENCY_ID = "Alert not found with emergency id: ";
        public static final String ALERT_NOT_FOUND_BY_CATALOG_ID = "Alert not found with catalog id: ";
        public static final String ALERT_LIST_EMPTY = "Alert list is empty";
        public static final String ALERT_CREATED = "Alert created successfully with id: ";
        public static final String ALERT_UPDATED = "Alert updated successfully with id: ";
        public static final String ALERT_DELETED = "Alert deleted successfully with id: ";
        public static final String ALERT_LIST = "Alert list retrieved successfully, size: ";
        public static final String ALERT_FOUND = "Alert found with id: ";
        public static final String ALERT_FOUND_BY_EMERGENCY_ID = "Alert found with emergency id: ";
        public static final String ALERT_FOUND_BY_CATALOG_ID = "Alert found with catalog id: ";
    }

    public static class AlertedService {
        private AlertedService() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String ALERTED_SERVICE_NOT_FOUND = "Alerted service not found with id: ";
        public static final String ALERTED_SERVICE_NOT_FOUND_BY_ACTION_ID = "Alerted service not found with action id: ";
        public static final String ALERTED_SERVICE_NOT_FOUND_BY_EMERGENCY_ID = "Alerted service not found with emergency id: ";
        public static final String ALERTED_SERVICE_LIST_EMPTY = "Alerted service list is empty";
        public static final String ALERTED_SERVICE_CREATED = "Alerted service created successfully with id: ";
        public static final String ALERTED_SERVICE_DELETED = "Alerted service deleted successfully with id: ";
        public static final String ALERTED_SERVICE_LIST = "Alerted service list retrieved successfully, size: ";
        public static final String ALERTED_SERVICES_FOUND_BY_EMERGENCY_ID = "Alerted services found with emergency id: ";
        public static final String ALERTED_SERVICES_FOUND_BY_ACTION_ID = "Alerted services found with action id: ";
    }

    public static class Call {
        private Call() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CALL_NOT_FOUND = "Call not found with id: ";
        public static final String CALL_NOT_FOUND_BY_OPERATOR_ID = "Call not found with operator id: ";
        public static final String CALL_NOT_FOUND_BY_PHONE_NUMBER = "Call not found with phone number: ";
        public static final String CALL_NOT_FOUND_BY_STATUS = "Call not found with status: ";
        public static final String CALL_NOT_FOUND_BY_CITY = "Call not found with city: ";
        public static final String CALL_LIST_EMPTY = "Call list is empty";
        public static final String CALL_CREATED = "Call created successfully with id: ";
        public static final String CALL_DELETED = "Call deleted successfully with id: ";
        public static final String CALL_LIST = "Call list retrieved successfully, size: ";
        public static final String CALLS_FOUND_BY_OPERATOR_ID = "Calls found with operator id: ";
        public static final String CALLS_FOUND_BY_PHONE_NUMBER = "Calls found with phone number: ";
        public static final String CALLS_FOUND_BY_STATUS = "Calls found with status: ";
        public static final String CALLS_FOUND_BY_CITY = "Calls found with city: ";
    }

    public static class CallStatus {
        private CallStatus() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CALL_STATUS_NOT_FOUND = "Call status not found with id: ";
        public static final String CALL_STATUS_NOT_FOUND_BY_NAME = "Call status not found with name: ";
        public static final String CALL_STATUS_LIST_EMPTY = "Call status list is empty";
        public static final String CALL_STATUS_CREATED = "Call status created successfully with id: ";
        public static final String CALL_STATUS_UPDATED = "Call status updated successfully with id: ";
        public static final String CALL_STATUS_DELETED = "Call status deleted successfully with id: ";
        public static final String CALL_STATUS_LIST = "Call status list retrieved successfully, size: ";
        public static final String CALL_STATUS_ALREADY_EXISTS = "Call status already exists with name: ";
        public static final String CALL_STATUS_FOUND_BY_NAME = "Call status found with name: ";
    }

    public static class City {
        private City() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String CITY_NOT_FOUND = "City not found with id: ";
        public static final String CITY_NOT_FOUND_BY_NAME = "City not found with name: ";
        public static final String CITY_LIST_EMPTY = "City list is empty";
        public static final String CITY_CREATED = "City created successfully with id: ";
        public static final String CITY_UPDATED = "City updated successfully with id: ";
        public static final String CITY_DELETED = "City deleted successfully with id: ";
        public static final String CITY_LIST = "City list retrieved successfully, size: ";
        public static final String CITY_ALREADY_EXISTS = "City already exists with name: ";
        public static final String CITY_FOUND_BY_NAME = "City found with name: ";
    }

    public static class Country {
        private Country() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String COUNTRY_NOT_FOUND = "Country not found with id: ";
        public static final String COUNTRY_NOT_FOUND_BY_NAME = "Country not found with name: ";
        public static final String COUNTRY_LIST_EMPTY = "Country list is empty";
        public static final String COUNTRY_CREATED = "Country created successfully with id: ";
        public static final String COUNTRY_UPDATED = "Country updated successfully with id: ";
        public static final String COUNTRY_DELETED = "Country deleted successfully with id: ";
        public static final String COUNTRY_LIST = "Country list retrieved successfully, size: ";
        public static final String COUNTRY_ALREADY_EXISTS = "Country already exists with name: ";
        public static final String COUNTRY_FOUND_BY_NAME = "Country found with name: ";
    }

    public static class Emergency {
        private Emergency() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String EMERGENCY_NOT_FOUND = "Emergency not found with id: ";
        public static final String EMERGENCY_NOT_FOUND_BY_NAME = "Emergency not found with name: ";
        public static final String EMERGENCY_LIST_EMPTY = "Emergency list is empty";
        public static final String EMERGENCY_CREATED = "Emergency created successfully with id: ";
        public static final String EMERGENCY_UPDATED = "Emergency updated successfully with id: ";
        public static final String EMERGENCY_DELETED = "Emergency deleted successfully with id: ";
        public static final String EMERGENCY_LIST = "Emergency list retrieved successfully, size: ";
        public static final String EMERGENCY_ALREADY_EXISTS = "Emergency already exists with name: ";
        public static final String EMERGENCY_FOUND_BY_NAME = "Emergency found with name: ";
    }

    public static class Operator {
        private Operator() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String OPERATOR_NOT_FOUND = "Operator not found with id: ";
        public static final String OPERATOR_NOT_FOUND_BY_NAME = "Operator not found with name: ";
        public static final String OPERATOR_LIST_EMPTY = "Operator list is empty";
        public static final String OPERATOR_CREATED = "Operator created successfully with id: ";
        public static final String OPERATOR_UPDATED = "Operator updated successfully with id: ";
        public static final String OPERATOR_DELETED = "Operator deleted successfully with id: ";
        public static final String OPERATOR_LIST = "Operator list retrieved successfully, size: ";
        public static final String OPERATOR_ALREADY_EXISTS = "Operator already exists with name: ";
        public static final String OPERATOR_FOUND_BY_NAME = "Operator found with name: ";
    }

    public static class PhoneNumber {
        private PhoneNumber() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PHONE_NUMBER_NOT_FOUND = "Phone number not found with id: ";
        public static final String PHONE_NUMBER_NOT_FOUND_BY_NUMBER = "Phone number not found with number: ";
        public static final String PHONE_NUMBER_LIST_EMPTY = "Phone number list is empty";
        public static final String PHONE_NUMBER_CREATED = "Phone number created successfully with id: ";
        public static final String PHONE_NUMBER_UPDATED = "Phone number updated successfully with id: ";
        public static final String PHONE_NUMBER_DELETED = "Phone number deleted successfully with id: ";
        public static final String PHONE_NUMBER_LIST = "Phone number list retrieved successfully, size: ";
        public static final String PHONE_NUMBER_ALREADY_EXISTS = "Phone number already exists with number: ";
        public static final String PHONE_NUMBER_FOUND_BY_NUMBER = "Phone number found with number: ";
    }

    public static class PhoneNumberStatus {
        private PhoneNumberStatus() {
            throw new IllegalStateException(BusinessMessage.ILLEGAL_STATE_EXCEPTION);
        }

        public static final String PHONE_NUMBER_STATUS_NOT_FOUND = "Phone number status not found with id: ";
        public static final String PHONE_NUMBER_STATUS_NOT_FOUND_BY_NAME = "Phone number status not found with name: ";
        public static final String PHONE_NUMBER_STATUS_LIST_EMPTY = "Phone number status list is empty";
        public static final String PHONE_NUMBER_STATUS_CREATED = "Phone number status created successfully with name: ";
        public static final String PHONE_NUMBER_STATUS_UPDATED = "Phone number status updated successfully with id: ";
        public static final String PHONE_NUMBER_STATUS_DELETED = "Phone number status deleted successfully with id: ";
        public static final String PHONE_NUMBER_STATUS_LIST = "Phone number status list retrieved successfully, size: ";
        public static final String PHONE_NUMBER_STATUS_ALREADY_EXISTS = "Phone number status already exists with name: ";
        public static final String PHONE_NUMBER_STATUS_FOUND_BY_NAME = "Phone number status found with name: ";
    }
}
