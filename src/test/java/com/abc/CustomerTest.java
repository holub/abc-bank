package com.abc;

import com.abc.account.Account;
import com.abc.account.type.CheckingAccountType;
import com.abc.account.type.MaxiSavingsAccountType;
import com.abc.account.type.SavingsAccountType;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test //Test customer statement generation
    public void testApp(){

        Account checkingAccount = new Account(new CheckingAccountType());
        Account savingsAccount = new Account(new SavingsAccountType());

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(new BigDecimal("100.0"));
        savingsAccount.deposit(new BigDecimal("4000.0"));
        savingsAccount.withdraw(new BigDecimal("200.0"));

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", henry.getStatement());
    }

    @Test
    public void testOneAccount(){
        Customer oscar = new Customer("Oscar").openAccount(new Account(new SavingsAccountType()));
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccount(){
        Customer oscar = new Customer("Oscar")
                .openAccount(new Account(new SavingsAccountType()));
        oscar.openAccount(new Account(new CheckingAccountType()));
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Test
    public void testThreeAcounts() {
        Customer oscar = new Customer("Oscar")
                .openAccount(new Account(new SavingsAccountType()));
        oscar.openAccount(new Account(new CheckingAccountType()));
        oscar.openAccount(new Account(new MaxiSavingsAccountType()));
        assertEquals(3, oscar.getNumberOfAccounts());
    }
}
