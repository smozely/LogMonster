package com.stevemosley.logmonster;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.common.collect.ImmutableMap;
import com.stevemosley.logmonster.util.DateTimeUtils;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Test;

import java.util.Map;

public class EventTest {

    @After
    public void cleanupDate() {
        DateTimeUtils.clearFixedDate();
    }

    @Test
    public void testConstruction() {

        // GIVEN
        DateTimeUtils.setCurrentDateFixed("2000-01-01T00:00:00");
        SystemIdProvider.setSystemId("SYSTEM ID");
        TransactionIdProvider.setCurrentIdentifier("IDENTIFIER");

        // WHEN
        Event result = new Event("LEVEL", "MESSAGE", ImmutableMap.of("KEY", "VAL"));

        // THEN
        assertThat(result.getDate(), is(new DateTime("2000-01-01T00:00:00")));
        assertThat(result.getSystem(), is("SYSTEM ID"));
        assertThat(result.getIdentifier(), is("IDENTIFIER"));
        assertThat(result.getLevel(), is("LEVEL"));
        assertThat(result.getMessage(), is("MESSAGE"));
        assertThat(result.getAttributes(), is((Map)ImmutableMap.of("KEY", "VAL")));

    }

}
