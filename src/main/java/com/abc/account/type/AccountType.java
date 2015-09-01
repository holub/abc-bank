package com.abc.account.type;

import com.abc.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by aholub on 8/31/15.
 */
public interface AccountType {

    String getName();
    BigDecimal interestEarned(Collection<Transaction> transactions, LocalDate toDate);
}
