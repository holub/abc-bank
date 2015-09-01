package com.abc;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static junit.framework.TestCase.assertFalse;

public class TransactionTest {

    @Test
    public void testTransactionDate() {
        Transaction t = new Transaction(new BigDecimal("5"));
        assertFalse(t.getTransactionDate().isAfter(LocalDateTime.now()));
    }
}
