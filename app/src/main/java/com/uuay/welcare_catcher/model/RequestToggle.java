package com.uuay.welcare_catcher.model;

public class RequestToggle {
    public final Long accountId;
    public final Long serviceId;

    public RequestToggle(Long accountId, Long serviceId) {
        this.accountId = accountId;
        this.serviceId = serviceId;
    }
}