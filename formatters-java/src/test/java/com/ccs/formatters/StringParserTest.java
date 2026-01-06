//
//  StringParserTest.java
//
//  Code Construct System 2006-2025
//
package com.ccs.Formatters;

import org.junit.Assert;
import org.junit.Test;

public class StringParserTest {
    @Test
    public void test() {
        parseStringTest();
    }

    private static void parseStringTest() {
        String tokenStringLine = "alpha,beta,gamma,delta,episilon";
      
        System.out.println("");
        System.out.println("class method StringParser.nextToken() test");
        System.out.println("------------------------------------------");
        System.out.println("token string line: " + tokenStringLine);
        System.out.println("");

        StringParser parser = new StringParser(tokenStringLine, ",\n");
      
        getNextToken(parser, "alpha");
        getNextToken(parser, "beta");
        getNextToken(parser, "gamma");
        getNextToken(parser, "delta");
        getNextToken(parser, "episilon");

        int count = parser.getTokenCount();

        System.out.println("");
        System.out.println("token count: " + count);
        System.out.println("");

        Assert.assertEquals(5, count);
    }

    private static void getNextToken(StringParser parser, String expected) {
        if (!parser.hasMoreTokens()) {
            System.out.println("no more tokens");
            return;
        }
  
        String token = parser.nextToken();
        System.out.println("token: " + token);

        Assert.assertEquals(expected, token);
    }
}