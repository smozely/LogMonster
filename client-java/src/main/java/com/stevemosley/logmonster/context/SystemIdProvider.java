package com.stevemosley.logmonster.context;

/**
 * This class provides a way of storing an retrieving the system id for logging.
 */
public class SystemIdProvider {

    private static String systemId;

    public static String getSystemId() {
        return systemId;
    }

    public static void setSystemId(String systemId) {
        if (SystemIdProvider.systemId == null) {
            SystemIdProvider.systemId = systemId;
        } else {
            throw new IllegalStateException("Server id has already been set.");
        }
    }
}
