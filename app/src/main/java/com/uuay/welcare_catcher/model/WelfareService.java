package com.uuay.welcare_catcher.model;

import java.util.Date;

public class WelfareService {
    private String serviceId;
    private String name;
    private String classification;
    private String application_agency;
    private String application_method;
    private String period;
    private String url;
    private Date registedAt;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getApplication_agency() {
        return application_agency;
    }

    public void setApplication_agency(String application_agency) {
        this.application_agency = application_agency;
    }

    public String getApplication_method() {
        return application_method;
    }

    public void setApplication_method(String application_method) {
        this.application_method = application_method;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getRegistedAt() {
        return registedAt;
    }

    public void setRegistedAt(Date registedAt) {
        this.registedAt = registedAt;
    }
}
