package com.stevemosley.logmonster.util;

import org.joda.time.DateTime;

public class DateTimeUtils {

    /**
     * Convience wrapper over the Joda DateTimeUtils for the common case of setting the date to a fixed string.
     */
    public static void setCurrentDateFixed(String date) {
        DateTime dateTime = new DateTime(date);
        org.joda.time.DateTimeUtils.setCurrentMillisFixed(dateTime.getMillis());
    }

    public static void clearFixedDate() {
        org.joda.time.DateTimeUtils.setCurrentMillisSystem();
    }
}
