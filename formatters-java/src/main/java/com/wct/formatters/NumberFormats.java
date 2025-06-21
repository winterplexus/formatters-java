//
//  NumberFormats.java
//
//  Wiregrass Code Technology 2006-2025
//
package com.wct.Formatters;

import java.math.BigDecimal;

public class NumberFormats {
    private static String[] ordtab = {
        "th", "st", "nd", "rd"
    };

    private static String[] unitstab = {
        "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten",  "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static String[] tenstab = {
        "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static String getOrdinal(int n) {
        if (((n %= 100) > 9 && n < 20) || (n %= 10) > 3) {
            n = 0;
        }
        return (ordtab[n]);
    }

    public static String getLiteralAmount(double amount) {
        StringBuffer buffer = new StringBuffer();
        buffer.setLength(0);

        if (amount < -999999999999999.00) {
            return "(under minimum amount limit -999,999,999,999,999.00)";
        }
        if (amount > 999999999999999.99) {
            return "(over maximum amount limit 999,999,999,999,999.99)";
        }
        if (amount < 0) {
            buffer.append("Minus ");
            amount = amount * -1;
        }

        int temporary = (int)(amount / 1E12);
        if (temporary > 0) {
            buffer.append(formatGroup(temporary, "Trillion"));
            amount = amount % 1E12;
        }
        temporary = (int)(amount / 1E9);
        if (temporary > 0) {
            buffer.append(formatGroup(temporary, "Billion"));
            amount = amount % 1E9;
        }
        temporary = (int)(amount / 1E6);
        if (temporary > 0) {
            buffer.append(formatGroup(temporary, "Million"));
            amount = amount % 1E6;
        }
        temporary = (int)(amount / 1E3);
        if (temporary > 0) {
            buffer.append(formatGroup(temporary, "Thousand"));
            amount = amount % 1E3;
        }

        buffer.append(formatGroup((int)amount, ""));

        if (buffer.length() < 1) {
            buffer.append(unitstab[0] + " ");
        }

        int fractional = (int)(getDecimalPart(amount) * 100. + .5);
        buffer.append("and " + fractional + "/100");
        return buffer.toString();
    }

    private static String formatGroup(int amount, String scale) {
        StringBuffer buffer = new StringBuffer();
        buffer.setLength(0);

        if (amount >= 100) {
            buffer.append(unitstab[amount / 100] + " Hundred ");
            amount %= 100;
        }
        if (amount >= 20) {
            buffer.append(tenstab[(amount - 20) / 10]);
            if (0 != (amount %= 10)) {
                buffer.append("-" + unitstab[amount] + " ");
            }
            else
                buffer.append(" ");
            }
        else if (amount > 0) {
            buffer.append(unitstab[amount] + " ");
        }
        if (scale.length() > 0) {
            buffer.append(scale + " ");
        }
        return buffer.toString();
    }

    private static double getDecimalPart(double d) {
        BigDecimal fp = new BigDecimal(d);
        String integral = null;
        String fractional = null;

        StringParser token = new StringParser(fp.toString(), ".");
        if (token.hasMoreElements()) {
            integral = token.nextToken();
        }
        if (token.hasMoreElements()) {
            fractional = token.nextToken();
        }
        if (fractional == null) {
            return 0.0;
        }
        else {
            BigDecimal dp = new BigDecimal("." + fractional);
            return dp.doubleValue();
        }
    }
}