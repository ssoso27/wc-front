package com.uuay.welcare_catcher.view.facilityList;

public enum ScreenName {
    KakaoMap(0),
    FacilityList(1);

    private final int value;

    private ScreenName() { this.value = 0; }

    private ScreenName(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
