package com.abc;

import com.abc.account.Account;
import com.abc.account.type.CheckingAccountType;
import com.abc.account.type.MaxiSavingsAccountType;
import com.abc.account.type.SavingsAccountType;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import static com.abc.test.AbcAssert.assertBigDecimalEquals;
import static org.junit.Assert.assertEquals;

public class BankTest {

    private LocalDate yearLater() {
        return LocalDate.now().plusDays(365);
    }

    @Test
    public void customerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new Account(new CheckingAccountType()));
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }

    @Test
    public void checkingAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(new CheckingAccountType());
        Customer bill = new Customer("Bill").openAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(new BigDecimal("100.0"));

        assertBigDecimalEquals("0.1", bank.totalInterestPaid(yearLater()));
    }

    @Test
    public void savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(new SavingsAccountType());
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(new BigDecimal("1500.0"));

        assertBigDecimalEquals("2.0", bank.totalInterestPaid(yearLater()));
    }

    @Test
    public void maxi_savings_account() {
        Bank bank = new Bank();
        Account checkingAccount = new Account(new MaxiSavingsAccountType());
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(new BigDecimal("3000.0"));

        assertBigDecimalEquals("170.0", bank.totalInterestPaid(yearLater()));
    }

}
