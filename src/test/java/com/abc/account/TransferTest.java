package com.abc.account;

import com.abc.account.type.CheckingAccountType;

import org.junit.Test;

import java.math.BigDecimal;

import static com.abc.test.AbcAssert.assertBigDecimalEquals;
import static junit.framework.TestCase.fail;

/**
 * Created by aholub on 8/31/15.
 */
public class TransferTest {

    @Test
    public void testUnsuccessful() {
        Account from = new Account(new CheckingAccountType());
        from.deposit(BigDecimal.TEN);

        Account to = new Account(new CheckingAccountType());
        to.deposit(new BigDecimal("200"));

        Transfer transfer = new Transfer(from, to);

        try {
            transfer.doTransfer(new BigDecimal("100"));
            fail("unreachable");
        } catch (IllegalArgumentException ias) {
            // ok!
        }

        assertBigDecimalEquals("10", from.sumTransactions());
        assertBigDecimalEquals("200", to.sumTransactions());
    }

    @Test
    public void testSuccessful() {
        Account from = new Account(new CheckingAccountType());
        from.deposit(new BigDecimal("100"));

        Account to = new Account(new CheckingAccountType());
        to.deposit(new BigDecimal("200"));

        Transfer transfer = new Transfer(from, to);
        transfer.doTransfer(new BigDecimal("30"));

        assertBigDecimalEquals("70", from.sumTransactions());
        assertBigDecimalEquals("230", to.sumTransactions());
    }
}