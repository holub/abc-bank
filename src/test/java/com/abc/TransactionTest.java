package com.abc;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class TransactionTest {

    @Test
    public void testTransactionDate() {
        Transaction t = new Transaction(new BigDecimal("5"));

        // XXX: No nanos for Date(). Dates can be equal.
        assertTrue(t.getTransactionDate().compareTo(new Date()) <= 0);
    }
}
