package com.abc;

import com.abc.account.Account;
import com.abc.account.type.CheckingAccountType;
import com.abc.account.type.MaxiSavingsAccountType;
import com.abc.account.type.SavingsAccountType;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

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
    public void testThreeAccounts() {
        Customer oscar = new Customer("Oscar")
                .openAccount(new Account(new SavingsAccountType()));
        oscar.openAccount(new Account(new CheckingAccountType()));
        oscar.openAccount(new Account(new MaxiSavingsAccountType()));
        assertEquals(3, oscar.getNumberOfAccounts());
    }
}
