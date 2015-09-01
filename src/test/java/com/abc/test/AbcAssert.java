package com.abc.test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by aholub on 8/31/15.
 */
public class AbcAssert {

    public static void assertBigDecimalEquals(String expected, BigDecimal actual) {
       BigDecimal bdExpected = new BigDecimal(expected);
        if(bdExpected.compareTo(actual) != 0) {
            assertEquals(expected, actual.toString());
        }
    }
}
