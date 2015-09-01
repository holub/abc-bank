package com.abc;

import com.abc.account.type.AccountType;
import com.abc.account.type.MaxiSavingsAccountType;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.abc.test.AbcAssert.assertBigDecimalEquals;

/**
 * Created by aholub on 9/1/15.
 */
public class MaxiSavingsAccountTypeTest {

    @Test
    public void testLowInterest() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction(new BigDecimal("1000"), LocalDateTime.now().minusDays(374)));
        transactions.add(new Transaction(new BigDecimal("-100"), LocalDateTime.now().minusDays(9)));

        AccountType account = new MaxiSavingsAccountType();
        assertBigDecimalEquals("50.00001", account.interestEarned(transactions, LocalDate.now()));
    }

    @Test
    public void testHighInterest() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction(new BigDecimal("1000"), LocalDateTime.now().minusDays(365)));

        AccountType account = new MaxiSavingsAccountType();
        assertBigDecimalEquals("50", account.interestEarned(transactions, LocalDate.now()));
    }
}
