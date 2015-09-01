package com.abc;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Transaction {
    private final BigDecimal amount;
    private final Date transactionDate;

    public Transaction(BigDecimal amount) {
        this.amount = amount;
        this.transactionDate = DateProvider.INSTANCE.now();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }
}
