package com.stevemosley.logmonster.api;

import com.stevemosley.logmonster.internal.AbstractEvent;

/**
 * This class represents an audit event.
 */
public class AuditEvent extends AbstractEvent {

    /* The auditIdentifier for this event type (i.e. LOGIN, LOGOUT) */
    private final String auditIdentifier;

    public AuditEvent(String identifier) {
        this.auditIdentifier = identifier;
    }

    public String getAuditIdentifier() {
        return auditIdentifier;
    }
}
