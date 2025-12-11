//
//  StringFormats.java
//
//  Code Construct System 2006-2025
//
package com.ccs.Formatters;

import java.text.StringCharacterIterator;

public class StringFormats {
    protected StringCharacterIterator specificationIterator;
    protected int specificationIndex;

    public String truncate(String text, int size) {
        if (text == null || (text.length() < 1)) {
            return text;
        }

        if (text.length() <= size) {
            return text;
        }
        else {
            return text.substring(0, size);
        }
    }

    public String format(String text, String specification) {
        String buffer = null;

        if (specification == null || (specification.length() < 1)) {
            return buffer;
        }

        setSpecificationIterator(specification);
        if (specificationIndex >= specificationIterator.getEndIndex()) {
            return buffer;
        }

        char value = getNextSpecificationCharacter();
        if (value != '%') {
            throw new IllegalArgumentException("invalid string format specification");
        }

        boolean leftJustified = false;
        boolean leadingZeroes = false;
        StringBuffer size = new StringBuffer();
        size.setLength(0);

        while (specificationIndex < specificationIterator.getEndIndex()) {
            value = getNextSpecificationCharacter();

            if (specificationIndex == 2) {
                if (value == '-') {
                    leftJustified = true;
                }
                else if (value == '0') {
                    leadingZeroes = true;
                }
                else {
                    size.append(value);
                }
            }
            else {
                size.append(value);
            }
        }

        int length = 0;

        try {
            length = Integer.parseInt(size.toString());
        }
        catch (NumberFormatException nfe) {
            throw nfe;
        }

        String truncatedText = truncate(text, length);
        if (leftJustified == true) {
            buffer = formatLeftJustified(truncatedText, length);
        }
        else if (leadingZeroes == true) {
            buffer = formatLeadingZeroes(truncatedText, length);
        }
        else {
            buffer = formatRightJustified(truncatedText, length);
        }
        return buffer;
    }

    private void setSpecificationIterator(String specification) {
        specificationIterator = new StringCharacterIterator(specification);
        specificationIndex = 0;
    }

    private char getNextSpecificationCharacter() {
        specificationIndex++;

        if (specificationIndex <= 1) {
            return specificationIterator.first();
        }
        if (specificationIndex > specificationIterator.getEndIndex()) {
            return StringCharacterIterator.DONE;
        }
        return specificationIterator.next();
    }

    private String formatLeftJustified(String text, int size) {
        if (text == null || (text.length() < 1)) {
           text = "";
        }

        StringBuffer buffer = new StringBuffer();
        buffer.append(text);
        for (int i = 0; i < (size - text.length()); i++) {
            buffer.append(" ");
        }

        return buffer.toString();
    }

    private String formatRightJustified(String text, int size) {
        if (text == null || (text.length() < 1)) {
            text = " ";
        }

        StringBuffer buffer = new StringBuffer();
        buffer.setLength(0);
        for (int i = 0; i < (size - text.length()); i++) {
            buffer.append(" ");
        }
        buffer.append(text);

        return buffer.toString();
    }

    private String formatLeadingZeroes(String text, int size) {
        if (text == null || (text.length() < 1)) {
            text = "0";
        }

        StringBuffer buffer = new StringBuffer();
        buffer.setLength(0);
        for (int i = 0; i < (size - text.length()); i++) {
            buffer.append("0");
        }
        buffer.append(text);

        return buffer.toString();
    }
}