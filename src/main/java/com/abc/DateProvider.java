package com.abc;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public enum DateProvider {

    // XXX: for current implementation Singleton implementation is not necessary
    INSTANCE;

    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
