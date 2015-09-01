package com.abc;

import java.util.Calendar;
import java.util.Date;

public enum DateProvider {

    // XXX: for current implementation Singleton implementation is not necessary
    INSTANCE;

    public Date now() {
        return Calendar.getInstance().getTime();
    }
}
