package com.stevemosley.logmonster;

import static com.google.common.base.Preconditions.*;
import static com.google.common.collect.ImmutableMap.copyOf;

import org.joda.time.DateTime;

import java.util.Map;

/**
 * This class represents an Event which can be logged to a LogMonster server.
 */
public class Event {

    private final DateTime date;

    private final String level;

    private final String server;

    private final String transactionId;

    private final Map<String, String> attributes;

    private final String message;

    public Event(String level, String message, Map<String, String> attributes) {
        this.date = new DateTime();
        this.level = checkNotNull(level);
        this.server = SystemIdProvider.getSystemId();
        this.transactionId = TransactionIdProvider.getCurrentTransactionId();
        this.attributes = copyOf(checkNotNull(attributes));
        this.message = checkNotNull(message);
    }

    public DateTime getDate() {
        return date;
    }

    public String getLevel() {
        return level;
    }

    public String getSystem() {
        return server;
    }

    public String getIdentifier() {
        return transactionId;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getMessage() {
        return message;
    }
}
