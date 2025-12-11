//
//  BooleanFormats.java
//
//  Code Construct System 2006-2025
//
package com.ccs.Formatters;

public class BooleanFormats {
    public static String getLiteral(boolean condition) {
        return condition ? "true" : "false";
    }

    public static char getLiteralLetter(boolean condition) {
        return condition ? 'T' : 'F';
    }
}