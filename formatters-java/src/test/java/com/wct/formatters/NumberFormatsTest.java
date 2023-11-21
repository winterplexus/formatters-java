//
//  NumberFormatsTest.java
//
//  Wiregrass Code Technology 2006-2023
//
package com.wct.Formatters;

import org.junit.Assert;
import org.junit.Test;

public class NumberFormatsTest {
    @Test
    public void test() {
        ordinalTest();
        literalAmountTest();
    }

    private static void ordinalTest() {
        System.out.println("");
        System.out.println("class method NumberFormats.getOrdinal() test");
        System.out.println("--------------------------------------------");
        System.out.println("1" + NumberFormats.getOrdinal(1));
        System.out.println("2" + NumberFormats.getOrdinal(2));
        System.out.println("3" + NumberFormats.getOrdinal(3));
        System.out.println("4" + NumberFormats.getOrdinal(4));

        Assert.assertEquals(NumberFormats.getOrdinal(1), "st");
        Assert.assertEquals(NumberFormats.getOrdinal(2), "nd");
        Assert.assertEquals(NumberFormats.getOrdinal(3), "rd");
        Assert.assertEquals(NumberFormats.getOrdinal(4), "th");
    }

    private static void literalAmountTest() {
        System.out.println("");
        System.out.println("class method NumberFormats.getLiteralAmount() test");
        System.out.println("--------------------------------------------------");
        System.out.println("amount: 0");
        System.out.println(NumberFormats.getLiteralAmount(0));
        System.out.println("amount: 1");
        System.out.println(NumberFormats.getLiteralAmount(1));
        System.out.println("amount: 1.01");
        System.out.println(NumberFormats.getLiteralAmount(1.01));
        System.out.println("amount: 12.02");
        System.out.println(NumberFormats.getLiteralAmount(12.02));
        System.out.println("amount: 123.03");
        System.out.println(NumberFormats.getLiteralAmount(123.03));
        System.out.println("amount: 1234.04");
        System.out.println(NumberFormats.getLiteralAmount(1234.04));
        System.out.println("amount: 12345.05");
        System.out.println(NumberFormats.getLiteralAmount(12345.05));
        System.out.println("amount: 123456.06");
        System.out.println(NumberFormats.getLiteralAmount(123456.06));
        System.out.println("amount: 1234567.07");
        System.out.println(NumberFormats.getLiteralAmount(1234567.07));
        System.out.println("amount: 12345678.08");
        System.out.println(NumberFormats.getLiteralAmount(12345678.08));
        System.out.println("amount: 123456789.09");
        System.out.println(NumberFormats.getLiteralAmount(123456789.09));
        System.out.println("amount: 1234567890.10");
        System.out.println(NumberFormats.getLiteralAmount(1234567890.10));
        System.out.println("amount: 12345678901.11");
        System.out.println(NumberFormats.getLiteralAmount(12345678901.11));
        System.out.println("amount: 123456789012.491");
        System.out.println(NumberFormats.getLiteralAmount(123456789012.491));
        System.out.println("amount: 1234567890123.501");
        System.out.println(NumberFormats.getLiteralAmount(1234567890123.501));
        System.out.println("amount: 12345678901234.5123");
        System.out.println(NumberFormats.getLiteralAmount(12345678901234.5123));
        System.out.println("amount:-1");
        System.out.println(NumberFormats.getLiteralAmount(-1));
        System.out.println("amount:-1.01");
        System.out.println(NumberFormats.getLiteralAmount(-1.01));
        System.out.println("amount:-12.02");
        System.out.println(NumberFormats.getLiteralAmount(-12.02));
        System.out.println("amount:-123.03");
        System.out.println(NumberFormats.getLiteralAmount(-123.03));
        System.out.println("amount:-1234.04");
        System.out.println(NumberFormats.getLiteralAmount(-1234.04));
        System.out.println("amount:-12345.05");
        System.out.println(NumberFormats.getLiteralAmount(-12345.05));
        System.out.println("amount:-123456.06");
        System.out.println(NumberFormats.getLiteralAmount(-123456.06));
        System.out.println("amount:-1234567.07");
        System.out.println(NumberFormats.getLiteralAmount(-1234567.07));
        System.out.println("amount:-12345678.08");
        System.out.println(NumberFormats.getLiteralAmount(-12345678.08));
        System.out.println("amount:-123456789.09");
        System.out.println(NumberFormats.getLiteralAmount(-123456789.09));
        System.out.println("amount:-1234567890.10");
        System.out.println(NumberFormats.getLiteralAmount(-1234567890.10));
        System.out.println("amount:-12345678901.11");
        System.out.println(NumberFormats.getLiteralAmount(-12345678901.11));
        System.out.println("amount:-123456789012.491");
        System.out.println(NumberFormats.getLiteralAmount(-123456789012.491));
        System.out.println("amount:-1234567890123.501");
        System.out.println(NumberFormats.getLiteralAmount(-1234567890123.501));
        System.out.println("amount:-12345678901234.5123");
        System.out.println(NumberFormats.getLiteralAmount(-12345678901234.5123));
        System.out.println("");
 
        Assert.assertEquals("Zero and 0/100",                                                                                                                                  NumberFormats.getLiteralAmount(0));
        Assert.assertEquals("One and 0/100",                                                                                                                                   NumberFormats.getLiteralAmount(1));
        Assert.assertEquals("One and 1/100",                                                                                                                                   NumberFormats.getLiteralAmount(1.01));
        Assert.assertEquals("Twelve and 2/100",                                                                                                                                NumberFormats.getLiteralAmount(12.02));
        Assert.assertEquals("One Hundred Twenty-Three and 3/100",                                                                                                              NumberFormats.getLiteralAmount(123.03));
        Assert.assertEquals("One Thousand Two Hundred Thirty-Four and 4/100",                                                                                                  NumberFormats.getLiteralAmount(1234.04));
        Assert.assertEquals("Twelve Thousand Three Hundred Forty-Five and 5/100",                                                                                              NumberFormats.getLiteralAmount(12345.05));
        Assert.assertEquals("One Hundred Twenty-Three Thousand Four Hundred Fifty-Six and 6/100",                                                                              NumberFormats.getLiteralAmount(123456.06));
        Assert.assertEquals("One Million Two Hundred Thirty-Four Thousand Five Hundred Sixty-Seven and 7/100",                                                                 NumberFormats.getLiteralAmount(1234567.07));
        Assert.assertEquals("Twelve Million Three Hundred Forty-Five Thousand Six Hundred Seventy-Eight and 8/100",                                                            NumberFormats.getLiteralAmount(12345678.08));
        Assert.assertEquals("One Hundred Twenty-Three Million Four Hundred Fifty-Six Thousand Seven Hundred Eighty-Nine and 9/100",                                            NumberFormats.getLiteralAmount(123456789.09));
        Assert.assertEquals("One Billion Two Hundred Thirty-Four Million Five Hundred Sixty-Seven Thousand Eight Hundred Ninety and 10/100",                                   NumberFormats.getLiteralAmount(1234567890.10));
        Assert.assertEquals("Twelve Billion Three Hundred Forty-Five Million Six Hundred Seventy-Eight Thousand Nine Hundred One and 11/100",                                  NumberFormats.getLiteralAmount(12345678901.11));
        Assert.assertEquals("One Hundred Twenty-Three Billion Four Hundred Fifty-Six Million Seven Hundred Eighty-Nine Thousand Twelve and 49/100",                            NumberFormats.getLiteralAmount(123456789012.491));
        Assert.assertEquals("One Trillion Two Hundred Thirty-Four Billion Five Hundred Sixty-Seven Million Eight Hundred Ninety Thousand One Hundred Twenty-Three and 50/100", NumberFormats.getLiteralAmount(1234567890123.501));
        Assert.assertEquals("Twelve Trillion Three Hundred Forty-Five Billion Six Hundred Seventy-Eight Million Nine Hundred One Thousand Two Hundred Thirty-Four and 51/100", NumberFormats.getLiteralAmount(12345678901234.5123));

        Assert.assertEquals("Zero and 0/100",                                                                                                                                        NumberFormats.getLiteralAmount(0));
        Assert.assertEquals("Minus One and 0/100",                                                                                                                                   NumberFormats.getLiteralAmount(-1));
        Assert.assertEquals("Minus One and 1/100",                                                                                                                                   NumberFormats.getLiteralAmount(-1.01));
        Assert.assertEquals("Minus Twelve and 2/100",                                                                                                                                NumberFormats.getLiteralAmount(-12.02));
        Assert.assertEquals("Minus One Hundred Twenty-Three and 3/100",                                                                                                              NumberFormats.getLiteralAmount(-123.03));
        Assert.assertEquals("Minus One Thousand Two Hundred Thirty-Four and 4/100",                                                                                                  NumberFormats.getLiteralAmount(-1234.04));
        Assert.assertEquals("Minus Twelve Thousand Three Hundred Forty-Five and 5/100",                                                                                              NumberFormats.getLiteralAmount(-12345.05));
        Assert.assertEquals("Minus One Hundred Twenty-Three Thousand Four Hundred Fifty-Six and 6/100",                                                                              NumberFormats.getLiteralAmount(-123456.06));
        Assert.assertEquals("Minus One Million Two Hundred Thirty-Four Thousand Five Hundred Sixty-Seven and 7/100",                                                                 NumberFormats.getLiteralAmount(-1234567.07));
        Assert.assertEquals("Minus Twelve Million Three Hundred Forty-Five Thousand Six Hundred Seventy-Eight and 8/100",                                                            NumberFormats.getLiteralAmount(-12345678.08));
        Assert.assertEquals("Minus One Hundred Twenty-Three Million Four Hundred Fifty-Six Thousand Seven Hundred Eighty-Nine and 9/100",                                            NumberFormats.getLiteralAmount(-123456789.09));
        Assert.assertEquals("Minus One Billion Two Hundred Thirty-Four Million Five Hundred Sixty-Seven Thousand Eight Hundred Ninety and 10/100",                                   NumberFormats.getLiteralAmount(-1234567890.10));
        Assert.assertEquals("Minus Twelve Billion Three Hundred Forty-Five Million Six Hundred Seventy-Eight Thousand Nine Hundred One and 11/100",                                  NumberFormats.getLiteralAmount(-12345678901.11));
        Assert.assertEquals("Minus One Hundred Twenty-Three Billion Four Hundred Fifty-Six Million Seven Hundred Eighty-Nine Thousand Twelve and 49/100",                            NumberFormats.getLiteralAmount(-123456789012.491));
        Assert.assertEquals("Minus One Trillion Two Hundred Thirty-Four Billion Five Hundred Sixty-Seven Million Eight Hundred Ninety Thousand One Hundred Twenty-Three and 50/100", NumberFormats.getLiteralAmount(-1234567890123.501));
        Assert.assertEquals("Minus Twelve Trillion Three Hundred Forty-Five Billion Six Hundred Seventy-Eight Million Nine Hundred One Thousand Two Hundred Thirty-Four and 51/100", NumberFormats.getLiteralAmount(-12345678901234.5123));
    }
}