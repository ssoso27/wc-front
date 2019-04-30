package com.uuay.welcare_catcher.model;

public enum MapButtonStatus {
    ToCurrentLocation(0),
    ToStopLocation(1),
    ToFixtedDirection(2);

    private final int value;

    private MapButtonStatus() { this.value = 0; }

    private MapButtonStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
