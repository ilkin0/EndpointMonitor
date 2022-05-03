package com.ilkinmehdiyev.msmonitor.util;

public interface Const {
    interface ApiUrl {
        String API_URL = "/api/v1";
        String MONITORED_ENDPOINT = API_URL + "/endpoint";
        String MONITORING_RESULT = MONITORED_ENDPOINT + "/{endpointId}/result";
    }
}
