package com.stevemosley.logmonster.api;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.google.common.collect.ImmutableMap;
import com.stevemosley.logmonster.context.ContextIdProvider;
import com.stevemosley.logmonster.context.MappedDiagnosticContextProvider;
import com.stevemosley.logmonster.context.SystemIdProvider;
import com.stevemosley.logmonster.util.DateTimeUtils;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class AuditEventTest {

    @Before
    public void setup() {
        if (SystemIdProvider.getSystemId() == null) {
            SystemIdProvider.setSystemId("SYSTEM ID");
        }
    }

    @After
    public void cleanup() {
        DateTimeUtils.clearFixedDate();
    }

    @Test
    public void testConstruction() {


        try {
            // GIVEN
            DateTimeUtils.setCurrentDateFixed("2000-01-01T00:00:00");
            ContextIdProvider.setCurrentContextId("IDENTIFIER");
            MappedDiagnosticContextProvider.push("AUDIT KEY", "VAL");

            // WHEN
            AuditEvent result = new AuditEvent("AUDIT ID");

            // THEN
            assertThat(result.getDate(), is(new DateTime("2000-01-01T00:00:00")));
            assertThat(result.getSystem(), is("SYSTEM ID"));
            assertThat(result.getContextIdentifier(), is("IDENTIFIER"));
            assertThat(result.getMappedDiagnosticContext(), is((Map) ImmutableMap.of("AUDIT KEY", "VAL")));
            assertThat(result.getAuditIdentifier(), is("AUDIT ID"));
        } finally {
            ContextIdProvider.clearCurrentContextId();
            MappedDiagnosticContextProvider.pop("AUDIT KEY");
        }
    }

}
