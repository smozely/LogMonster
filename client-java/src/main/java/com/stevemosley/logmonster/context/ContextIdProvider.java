package com.stevemosley.logmonster.context;

/**
 * This class provides a way of storing an retrieving the current context id for logging.
 */
public class ContextIdProvider {

    private static ThreadLocal<String> currentTransactionId = new ThreadLocal<>();

    public static String getCurrentContextId() {
        return currentTransactionId.get();
    }

    public static void setCurrentContextId(String value) {
        currentTransactionId.set(value);
    }

    public static void clearCurrentContextId() {
        currentTransactionId.remove();
    }

}
