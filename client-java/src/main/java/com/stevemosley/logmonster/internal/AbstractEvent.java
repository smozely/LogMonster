package com.stevemosley.logmonster.internal;

import com.stevemosley.logmonster.context.ContextIdProvider;
import com.stevemosley.logmonster.context.MappedDiagnosticContextProvider;
import com.stevemosley.logmonster.context.SystemIdProvider;
import org.joda.time.DateTime;

import java.util.Map;

/**
 * This class represents an AbstractEvent. That is the when / where an event occurred.
 *
 * But the what occurred is left to subclasses to implement.
 */
public abstract class AbstractEvent {

    /* The time this event occurred */
    private final DateTime date;

    /* The system this event occurred on */
    private final String system;

    /* The context this event occurred under (i.e. Transaction ID, Thread ID, ...) */
    private final String contextIdentifier;

    private final Map<String, String> mdc;

    protected AbstractEvent() {
        this.date = new DateTime();
        this.system = SystemIdProvider.getSystemId();
        this.contextIdentifier = ContextIdProvider.getCurrentContextId();
        this.mdc = MappedDiagnosticContextProvider.getCurrentMDC();
    }

    public DateTime getDate() {
        return date;
    }

    public String getSystem() {
        return system;
    }

    public String getContextIdentifier() {
        return contextIdentifier;
    }

    public Map<String, String> getMappedDiagnosticContext() {
        return mdc;
    }
}
