package com.abc.account;

import com.abc.account.type.CheckingAccountType;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by aholub on 8/31/15.
 */
public class AccountTest {

    @Test(expected = IllegalArgumentException.class)
    public void testZeroDeposit() {
        Account account = new Account(new CheckingAccountType());
        account.deposit(BigDecimal.ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDeposit() {
        Account account = new Account(new CheckingAccountType());
        account.deposit(new BigDecimal("-0.009"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroWithdraw() {
        Account account = new Account(new CheckingAccountType());
        account.withdraw(BigDecimal.ZERO);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeWithdraw() {
        Account account = new Account(new CheckingAccountType());
        account.withdraw(new BigDecimal("-0.009"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawFromEmpty() {
        Account account = new Account(new CheckingAccountType());
        account.withdraw(new BigDecimal("100"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawMore() {
        Account account = new Account(new CheckingAccountType());
        account.deposit(new BigDecimal("100"));
        account.withdraw(new BigDecimal("200"));
    }
}