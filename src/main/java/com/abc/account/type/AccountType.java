package com.abc.account.type;

import com.abc.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by aholub on 8/31/15.
 */
public interface AccountType {

    String getName();
    BigDecimal interestEarned(List<Transaction> transactions, LocalDate toDate);
}
