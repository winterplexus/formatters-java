//
//  StringFormatsTest.java
//
//  Wiregrass Code Technology 2006-2023
//
package com.wct.Formatters;

import org.junit.Assert;
import org.junit.Test;

public class StringFormatsTest {
    @Test
    public void test() {
        stringTruncateTest();
        stringFormatsNullTest();
        stringFormatsPartialTest();
        stringFormatsFullTest();
    }

    private static void stringTruncateTest() {
        String value = "truncate";

        StringFormats sf = new StringFormats();

        String truncate1 = sf.truncate(value, 1);
        String truncate2 = sf.truncate(value, 4);
        String truncate3 = sf.truncate(value, 8);

        System.out.println("");
        System.out.println("class method StringFormats.truncate() test: " + value);
        System.out.println("----------------------------------------------------");
        System.out.println("truncate by 1: " + truncate1);
        System.out.println("truncate by 4: " + truncate2);
        System.out.println("truncate by 8: " + truncate3);

        Assert.assertEquals("t",        truncate1);
        Assert.assertEquals("trun",     truncate2);
        Assert.assertEquals("truncate", truncate3);
    }

    private static void stringFormatsNullTest() {
        String value = null;

        StringFormats sf = new StringFormats();

        try {
            String format1 = sf.format(value, "%1");
            String format2 = sf.format(value, "%1");
            String format3 = sf.format(value, "%1");
            String format4 = sf.format(value, "%10");
            String format5 = sf.format(value, "%-10");
            String format6 = sf.format(value, "%010");

            System.out.println("");
            System.out.println("class method StringFormats.format() test: " + value);
            System.out.println("----------------------------------------------");

            System.out.println("%1   : " + format1);
            System.out.println("%1   : " + format2);
            System.out.println("%1   : " + format3);
            System.out.println("%10  : " + format4);
            System.out.println("%-10 : " + format5);
            System.out.println("%010 : " + format6);

            Assert.assertEquals(" ",          format1);
            Assert.assertEquals(" ",          format2);
            Assert.assertEquals(" ",          format3);
            Assert.assertEquals("          ", format4);
            Assert.assertEquals("          ", format5);
            Assert.assertEquals("0000000000", format6);
        }
        catch (IllegalArgumentException iae) {
            System.out.println("exception: " + iae.getMessage());
        }
    }
    
    private static void stringFormatsPartialTest() {
        String value = "A";

        StringFormats sf = new StringFormats();

        try {
            String format1 = sf.format(value, "%1");
            String format2 = sf.format(value, "%1");
            String format3 = sf.format(value, "%1");
            String format4 = sf.format(value, "%10");
            String format5 = sf.format(value, "%-10");
            String format6 = sf.format(value, "%010");

            System.out.println("");
            System.out.println("class method StringFormats.format() test: " + value);
            System.out.println("----------------------------------------------");
            System.out.println("%1   : " + format1);
            System.out.println("%1   : " + format2);
            System.out.println("%1   : " + format3);
            System.out.println("%10  : " + format4);
            System.out.println("%-10 : " + format5);
            System.out.println("%010 : " + format6);

            Assert.assertEquals("A",          format1);
            Assert.assertEquals("A",          format2);
            Assert.assertEquals("A",          format3);
            Assert.assertEquals("         A", format4);
            Assert.assertEquals("A         ", format5);
            Assert.assertEquals("000000000A", format6);
        }
        catch (IllegalArgumentException iae) {
            System.out.println("exception: " + iae.getMessage());
        }
    }
    
    private static void stringFormatsFullTest() {
        String value = "A1B2";

        StringFormats sf = new StringFormats();

        try {
            String format1 = sf.format(value, "%1");
            String format2 = sf.format(value, "%1");
            String format3 = sf.format(value, "%1");
            String format4 = sf.format(value, "%10");
            String format5 = sf.format(value, "%-10");
            String format6 = sf.format(value, "%010");

            System.out.println("");
            System.out.println("class method StringFormats.format() test: " + value);
            System.out.println("----------------------------------------------");
            System.out.println("%1   : " + format1);
            System.out.println("%1   : " + format2);
            System.out.println("%1   : " + format3);
            System.out.println("%10  : " + format4);
            System.out.println("%-10 : " + format5);
            System.out.println("%010 : " + format6);
            System.out.println("");

            Assert.assertEquals("A",          format1);
            Assert.assertEquals("A",          format2);
            Assert.assertEquals("A",          format3);
            Assert.assertEquals("      A1B2", format4);
            Assert.assertEquals("A1B2      ", format5);
            Assert.assertEquals("000000A1B2", format6);
        }
        catch (IllegalArgumentException iae) {
            System.out.println("exception: " + iae.getMessage());
        }
    }
}