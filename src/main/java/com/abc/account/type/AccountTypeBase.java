package com.abc.account.type;

import com.abc.Transaction;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.List;

import static java.math.BigDecimal.ZERO;

/**
 * Created by aholub on 8/31/15.
 */
abstract class AccountTypeBase implements AccountType {

    public BigDecimal interestEarned(List<Transaction> transactions, LocalDate toDate) {
        TransactionsNavigator transactionsNavigator = new TransactionsNavigator(transactions);
        BigDecimal totalInterest = ZERO;

        for(Transaction transaction : transactions) {
            totalInterest = totalInterest.add(interestEarned(transaction, transactionsNavigator));
        }

        long days = transactionsNavigator.getDaysSinceLastTransaction(toDate);
        if(days > 0) {
            BigDecimal balance = transactionsNavigator.getBalance();
            return totalInterest.add(interestEarned(balance, days));
        } else {
            return totalInterest;
        }
    }

    public BigDecimal interestEarned(Transaction transaction, TransactionsNavigator transactionsNavigator) {
        Transaction previousTransaction = transactionsNavigator.getPreviousTransaction(transaction);
        if(previousTransaction != null) {
            BigDecimal previousBalance = transactionsNavigator.getBalance(previousTransaction);
            long days = transactionsNavigator.getDaysSincePreviousTransaction(transaction);
            return interestEarned(previousBalance, days);
        } else {
            return ZERO;
        }
    }

    public BigDecimal interestEarned(BigDecimal amount, long days) {
        return annualInterest(amount).multiply(BigDecimal.valueOf(days)).divide(new BigDecimal("365"), MathContext.DECIMAL128);
    }

    public abstract BigDecimal annualInterest(BigDecimal amount);
}
