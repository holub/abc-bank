package com.abc.account;

import com.abc.Transaction;
import com.abc.account.type.AccountType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private final AccountType accountType;
    private final List<Transaction> transactions;

    public Account(AccountType accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

public void withdraw(BigDecimal amount) {
    if (amount.compareTo(BigDecimal.ZERO) <= 0) {
        throw new IllegalArgumentException("amount must be greater than zero");
    } else {
        synchronized (this) {
            if (sumTransactions().compareTo(amount) < 0) {
                throw new IllegalArgumentException("insufficient founds");
            } else {
                transactions.add(new Transaction(amount.negate()));
            }
        }
    }
}

    public BigDecimal interestEarned(LocalDate toDate) {
        return accountType.interestEarned(getTransactions(), toDate);
    }

    public BigDecimal sumTransactions() {
        BigDecimal amount = BigDecimal.ZERO;
        for (Transaction t: getTransactions())
            amount = amount.add(t.getAmount());
        return amount;
    }

    public String getAccountName() {
        return accountType.getName();
    }

}
