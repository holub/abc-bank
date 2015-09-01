package com.abc.account.type;

import com.abc.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

/**
 * Created by aholub on 8/31/15.
 */
abstract class AccountTypeBase implements AccountType {

    public BigDecimal interestEarned(Collection<Transaction> transactions, LocalDate toDate) {
        BigDecimal total = BigDecimal.ZERO;
        for(Transaction transaction : transactions) {
            long days = ChronoUnit.DAYS.between(transaction.getTransactionDate().toLocalDate(), toDate);
            total = total.add(interestEarned(transaction.getAmount(), days));
        }
        return total;
    }

    public BigDecimal interestEarned(BigDecimal amount, long days) {
        return annualInterest(amount).multiply(BigDecimal.valueOf(days)).divide(new BigDecimal("365"));
    }

    public abstract BigDecimal annualInterest(BigDecimal amount);
}
