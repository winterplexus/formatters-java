//
//  BooleanFormats.java
//
//  Wiregrass Code Technology 2006-2023
//
package com.wct.Formatters;

public class BooleanFormats {
    public static String getLiteral(boolean condition) {
        return condition ? "true" : "false";
    }

    public static char getLiteralLetter(boolean condition) {
        return condition ? 'T' : 'F';
    }
}