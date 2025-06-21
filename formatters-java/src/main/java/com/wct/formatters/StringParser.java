//
//  StringParser.java
//
//  Wiregrass Code Technology 2006-2025
//
package com.wct.Formatters;

import java.text.StringCharacterIterator;

public class StringParser {
    protected StringCharacterIterator source;
    protected StringCharacterIterator delimiters;
    protected int position;
    protected char s;
    protected boolean eos;
    protected boolean returnBlank;
    protected StringBuffer token;
    protected String sc;
    protected int tokenCount;

    public StringParser(String text, String textDelimiters) {
        source = new StringCharacterIterator(text);
        delimiters = new StringCharacterIterator(textDelimiters);
        position = 0;
        s = source.first();
        eos = false;
        returnBlank = false;
        token = new StringBuffer();
        sc = text;
        tokenCount = 0;
    }

    public synchronized String nextToken() {
        if (eos) {
            eos = false;
        }
        for (int i = position; i < source.getEndIndex(); i++, position++) {
            if (isDelimiter(s)) {
                s = source.next();
                position++;
                if (position >= source.getEndIndex()) {
                    eos = true;
                }
                return getTokenStringValue();
            }
            token = token.append(s);
            s = source.next();
        }
        return getTokenStringValue();
    }

    public boolean hasMoreElements() {
        if (eos || (position < source.getEndIndex())) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean hasMoreTokens() {
        if (eos || (position < source.getEndIndex())) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getPosition() {
        return position;
    }

    public int getTokenCount() {
        if (tokenCount > 0) {
            return tokenCount;
        }

        StringCharacterIterator sci = new StringCharacterIterator(sc);
        char c = sci.first();

        tokenCount = 1;

        for (int i = 0; i < sci.getEndIndex(); i++) {
            if (isDelimiter(c)) {
                tokenCount++;
            }
            c = sci.next();
        }
        return tokenCount;
    }

    public void setReturnBlankTokenString(boolean returnBlank) {
        this.returnBlank = returnBlank;
    }

    private boolean isDelimiter(char compare) {
        char c = delimiters.first();

        for (int i = 0; i < delimiters.getEndIndex(); i++) {
            if (c == compare) {
                return true;
            }
            c = delimiters.next();
        }
        return false;
    }

    private synchronized String getTokenStringValue() {
        if (token.length() < 1) {
            if (returnBlank) {
                return "";
            }
            else {
                return null;
            }
        }
        String value = new String(token.toString());
        token.delete(0, token.length());
        return value;
    }
}