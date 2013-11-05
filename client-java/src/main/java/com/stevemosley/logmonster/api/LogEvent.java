package com.stevemosley.logmonster.api;

import com.stevemosley.logmonster.internal.AbstractEvent;
import com.stevemosley.logmonster.internal.Level;

/**
 * This class represents a log event.
 */
public class LogEvent extends AbstractEvent {

    /* The message for this log event */
    private final String message;
    private final Level level;

    public LogEvent(Level level, String message) {
        super();
        this.level = level;
        this.message = message;
    }

    public Level getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
