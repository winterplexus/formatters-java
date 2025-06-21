//
//  DataTimeFormats.java
//
//  Wiregrass Code Technology 2006-2025
//
package com.wct.Formatters;

import java.text.StringCharacterIterator;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateTimeFormats {
    private static final String[] dowtab = {
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday",
    };

    private static final String[] sdowtab = {
        "Mon", "Tue", "Wed", "Thr", "Fri", "Sat", "Sun"
    };

    private static final String[] montab = {
        "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };

    private static final String[] smontab = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    protected StringCharacterIterator specificationIterator;
    protected int specificationIndex;

    public String format(String specification) {
        ZonedDateTime dt = ZonedDateTime.now();
        return format(specification, dt);
    }

    /**
     *  Format output using specification and given date and time.
     *
     *  specification :  %a - abbreviated weekday name
     *                   %A - full weekday name
     *                   %b - abbreviated month name
     *                   %B - full month name
     *                   %c - locale-specific date and time
     *                   %d - day of the month as integer (01-31)
     *                   %H - hour (24-hour clock)
     *                   %I - hour (12-hour clock)
     *                   %j - day of the year as integer (001-366)
     *                   %m - month as integer (01-12)
     *                   %M - minute as integer (00-59)
     *                   %p - locale AM/PM designation
     *                   %S - second as integer (00-59)
     *                   %w - weekday as integer (0-6)
     *                   %W - week number of the year (00-52)
     *                   %x - locale specific date
     *                   %X - locale specific time
     *                   %y - year without century (00-99)
     *                   %Y - year with century
     *                   %Z - time zone name
     *                   %% - a single %
     */
    public String format(String specification, ZonedDateTime dt) {
        StringBuffer buffer = new StringBuffer();
        buffer.setLength(0);

        if (specification == null || specification.length() < 1) {
            return buffer.toString();
        }

        StringFormats stringFormats = new StringFormats();

        setSpecificationIterator(specification);

        while (specificationIndex < specificationIterator.getEndIndex()) {
            char value = getNextSpecificationCharacter();
            if (value == '%') {
                value = getNextSpecificationCharacter();

                if (value == 'a') {
                    buffer.append(sdowtab[dt.getDayOfWeek().getValue() - 1]);
                }
                else if (value == 'A') {
                    buffer.append(dowtab[dt.getDayOfWeek().getValue() - 1]);
                }
                else if (value == 'b') {
                    buffer.append(smontab[dt.getMonth().getValue() - 1]);
                }
                else if (value == 'B') {
                    buffer.append(montab[dt.getMonth().getValue() - 1]);
                }
                else if (value == 'c') {
                    return this.format("%a %b %d %H:%M:%S %Y", dt);
                }
                else if (value == 'd') {
                    buffer.append(stringFormats.format(String.valueOf(dt.getDayOfMonth()), "%02"));
                }
                else if (value == 'H') {
                    buffer.append(stringFormats.format(String.valueOf(dt.getHour()), "%02"));
                }
                else if (value == 'I') {
                    buffer.append(stringFormats.format(String.valueOf((dt.getHour() > 12) ? dt.getHour() - 12 : dt.getHour()), "%02"));
                }
                else if (value == 'j') {
                    buffer.append(String.valueOf(dt.getDayOfYear()));
                }
                else if (value == 'm') {
                    buffer.append(stringFormats.format(String.valueOf(dt.getMonthValue()), "%02"));
                }
                else if (value == 'M') {
                    buffer.append(stringFormats.format(String.valueOf(dt.getMinute()), "%02"));
                }
                else if (value == 'p') {
                    buffer.append((dt.getHour() > 12) ? "PM" : "AM");
                }
                else if (value == 'S') {
                    buffer.append(stringFormats.format(String.valueOf(dt.getSecond()), "%02"));
                }
                else if (value == 'w') {
                    buffer.append(String.valueOf(dt.getDayOfWeek().getValue()));
                }
                else if (value == 'W') {
                    buffer.append(String.valueOf((int)Math.ceil(dt.getDayOfYear() / 7.0)));
                }
                else if (value == 'x') {
                    return this.format("%m/%d/%y", dt);
                }
                else if (value == 'X') {
                    return this.format("%H:%M:%S", dt);
                }
                else if (value == 'y') {
                    buffer.append(stringFormats.format(String.valueOf(dt.getYear()).substring(2, 4), "%02"));
                }
                else if (value == 'Y') {
                    buffer.append(stringFormats.format(String.valueOf(dt.getYear()), "%04"));
                }
                else if (value == 'Z') {
                    buffer.append(dt.getZone().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH));
                }
                else if (value == '%') {
                    buffer.append(value);
                }
                else {
                    throw new IllegalArgumentException("invalid date time specification");
                }
            }
            else {
                buffer.append(value);
            }
        }
        return buffer.toString();
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
            return specificationIterator.DONE;
        }
        return specificationIterator.next();
    }
}