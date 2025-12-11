//
//  BooleanFormatsTest.java
//
//  Code Construct System 2006-2025
//
package com.ccs.Formatters;

import org.junit.Assert;
import org.junit.Test;

public class BooleanFormatsTest {
    @Test
    public void test() {
        literalTest();
        literalLetterTest();
    }

    private static void literalTest() {
        System.out.println("");
        System.out.println("class method BooleanFormats.getLiteral() test");
        System.out.println("---------------------------------------------");
        System.out.println("boolean literal for true         : " + BooleanFormats.getLiteral(true));
        System.out.println("boolean literal for false        : " + BooleanFormats.getLiteral(false));
        System.out.println("");

        Assert.assertEquals("true",  BooleanFormats.getLiteral(true));
        Assert.assertEquals("false", BooleanFormats.getLiteral(false));
    }
    
    private static void literalLetterTest() {
        System.out.println("class method BooleanFormats.getLiteralLetter() test");
        System.out.println("---------------------------------------------------");
        System.out.println("boolean literal letter for true  : " + BooleanFormats.getLiteralLetter(true));
        System.out.println("boolean literal letter for false : " + BooleanFormats.getLiteralLetter(false));
        System.out.println("");

        Assert.assertEquals('T', BooleanFormats.getLiteralLetter(true));
        Assert.assertEquals('F', BooleanFormats.getLiteralLetter(false));
    }
}