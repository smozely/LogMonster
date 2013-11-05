package com.stevemosley.logmonster.context;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * This class provides a way of storing an retrieving the current mapped diagnostic context for logging.
 */
public class MappedDiagnosticContextProvider {

    private static ThreadLocal<Map<String, String>> currentMdc = new ThreadLocal<Map<String, String>>() {
        @Override
        protected Map<String, String> initialValue() {
            return Maps.newHashMap();
        }
    };

    public static Map<String, String> getCurrentMDC() {
        return ImmutableMap.copyOf(currentMdc.get());
    }

    public static void push(String key, String value) {
        currentMdc.get().put(key, value);
    }

    public static void pop(String key) {
        currentMdc.get().remove(key);
    }

}
