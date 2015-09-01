package com.abc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Transaction {
    private final BigDecimal amount;
    private final LocalDateTime transactionDate;

    public Transaction(BigDecimal amount) {
        this.amount = amount;
        this.transactionDate = DateProvider.INSTANCE.now();
    }

    // XXX: for testing only!
    protected Transaction(BigDecimal amount, LocalDateTime transactionDate) {
       this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
}
