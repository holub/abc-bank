package com.abc.account;

import com.abc.Transaction;
import com.abc.account.type.AccountType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private final AccountType accountType;
    public List<Transaction> transactions;

    public Account(AccountType accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
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
        transactions.add(new Transaction(amount.negate()));
    }
}

    public BigDecimal interestEarned() {
        BigDecimal amount = sumTransactions();
        return accountType.interestEarned(amount);
    }

    public BigDecimal sumTransactions() {
       return checkIfTransactionsExist(true);
    }

    private BigDecimal checkIfTransactionsExist(boolean checkAll) {
        BigDecimal amount = BigDecimal.ZERO;
        for (Transaction t: transactions)
            amount = amount.add(t.amount);
        return amount;
    }

    public String getAccountName() {
        return accountType.getName();
    }

}
