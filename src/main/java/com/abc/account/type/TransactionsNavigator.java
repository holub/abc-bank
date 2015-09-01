package com.abc.account.type;

import com.abc.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;

/**
 * Created by aholub on 9/1/15.
 */
public class TransactionsNavigator {
    final List<Transaction> allTransactions;

    public TransactionsNavigator(List<Transaction> allTransactions) {
        this.allTransactions = Collections.unmodifiableList(allTransactions);
    }

    public BigDecimal getBalance() {
        Transaction lastTransaction = getLastTransaction();
        return lastTransaction != null
                ? getBalance(lastTransaction)
                : BigDecimal.ZERO;
    }

    public BigDecimal getBalance(Transaction withTransaction) {
        BigDecimal balance = BigDecimal.ZERO;
        for(Transaction transaction : allTransactions) {
            balance = balance.add(transaction.getAmount());
            if(transaction.equals(withTransaction)) {
                return balance;
            }
        }
        return balance;
    }

    public Transaction getLastTransaction() {
        return allTransactions.size() > 0
                ? allTransactions.get(allTransactions.size()-1)
                : null;
    }

    public long getDaysSinceLastTransaction(LocalDate toDate) {
        Transaction lastTransaction = getLastTransaction();
        return lastTransaction != null
                ? ChronoUnit.DAYS.between(lastTransaction.getTransactionDate().toLocalDate(), toDate)
                : 0;
    }

    public long getDaysSincePreviousTransaction(Transaction currentTransaction) {
        Transaction previousTransaction = getPreviousTransaction(currentTransaction);
        return previousTransaction == null
                ? 0
                : ChronoUnit.DAYS.between(previousTransaction.getTransactionDate(), currentTransaction.getTransactionDate());
    }

    public Transaction getPreviousTransaction(Transaction currentTransaction) {
        int currentTransactionIndex = allTransactions.indexOf(currentTransaction);
        return currentTransactionIndex > 0
                ? allTransactions.get(currentTransactionIndex - 1)
                : null;
    }

    public Transaction getPreviousWithdraw(Transaction currentTransaction) {
        for(int i=allTransactions.indexOf(currentTransaction); i>=0; i--) {
            Transaction t = allTransactions.get(i);
            if(t.getAmount().compareTo(BigDecimal.ZERO) < 0) {
                return t;
            }
        }
        return null;
    }

    public Transaction getPreviousDeposit(Transaction currentTransaction) {
        for(int i=allTransactions.indexOf(currentTransaction); i>=0; i--) {
            Transaction t = allTransactions.get(i);
            if(t.getAmount().compareTo(BigDecimal.ZERO) > 0) {
                return t;
            }
        }
        return null;
    }
}
