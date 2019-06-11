package com.uuay.welcare_catcher.util;

import java.util.HashMap;
import java.util.Map;

public class LocalCookie {
    private static Map<String, String> cookies;

    private LocalCookie() {
        cookies = new HashMap<String, String>();
    }

    private static class LocalCookieHolder {
        public static final LocalCookie INSTANCE = new LocalCookie();
    }

    public static LocalCookie getInstance() {
        return LocalCookieHolder.INSTANCE;
    }

    public void put(String key, String value) {
        cookies.put(key, value);
    }

    public String get(String key) {
        return cookies.get(key);
    }

    public Boolean containsKey(String key) {
        return cookies.containsKey(key);
    }

    public Boolean isEmpty() {
        return cookies.isEmpty();
    }
}
