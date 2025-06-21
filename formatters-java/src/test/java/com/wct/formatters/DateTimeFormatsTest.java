//
//  DateTimeFormatsTest.java
//
//  Wiregrass Code Technology 2006-2025
//
package com.wct.Formatters;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import org.junit.Assert;
import org.junit.Test;

public class DateTimeFormatsTest {
    @Test
    public void test() {
        dateformatsTest();
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
    private static void dateformatsTest() {
        LocalDateTime ldt = LocalDateTime.parse("2023-01-05T15:05:55");
        ZonedDateTime dt = ZonedDateTime.of(ldt, ZoneId.of("America/New_York"));

        DateTimeFormats df = new DateTimeFormats();

        String format1  = df.format("%a", dt);
        String format2  = df.format("%A", dt);
        String format3  = df.format("%b", dt);
        String format4  = df.format("%B", dt);
        String format5  = df.format("%a %A %b %B", dt);
        String format6  = df.format("%d", dt);
        String format7  = df.format("%m", dt);
        String format8  = df.format("%y", dt);
        String format9  = df.format("%Y", dt);
        String format10 = df.format("%m/%d/%y", dt);
        String format11 = df.format("%S", dt);
        String format12 = df.format("%M", dt);
        String format13 = df.format("%I", dt);
        String format14 = df.format("%H", dt);
        String format15 = df.format("%p", dt);
        String format16 = df.format("%I:%M:%S %p", dt);
        String format17 = df.format("%x", dt);
        String format18 = df.format("%X", dt);
        String format19 = df.format("%c", dt);
        String format20 = df.format("%w", dt);
        String format21 = df.format("%Z", dt);
        String format22 = df.format("%j", dt);
        String format23 = df.format("%W", dt);

        System.out.println("");
        System.out.println("class method DateTimeFormats.format() test");
        System.out.println("------------------------------------------");
        System.out.println("%a          : " + format1);
        System.out.println("%A          : " + format2);
        System.out.println("%b          : " + format3);
        System.out.println("%B          : " + format4);
        System.out.println("%a %A %b %b : " + format5);
        System.out.println("%d          : " + format6);
        System.out.println("%m          : " + format7);
        System.out.println("%y          : " + format8);
        System.out.println("%Y          : " + format9);
        System.out.println("%m/%d/%y    : " + format10);
        System.out.println("%S          : " + format11);
        System.out.println("%M          : " + format12);
        System.out.println("%I          : " + format13);
        System.out.println("%H          : " + format14);
        System.out.println("%p          : " + format15);
        System.out.println("%H:%M:%S %p : " + format16);
        System.out.println("%x          : " + format17);
        System.out.println("%X          : " + format18);
        System.out.println("%c          : " + format19);
        System.out.println("%w          : " + format20);
        System.out.println("%Z          : " + format21);
        System.out.println("%j          : " + format22);
        System.out.println("%W          : " + format23);
        System.out.println("");

        Assert.assertEquals("Thr",                      format1);
        Assert.assertEquals("Thursday",                 format2);
        Assert.assertEquals("Jan",                      format3);
        Assert.assertEquals("January",                  format4);
        Assert.assertEquals("Thr Thursday Jan January", format5);
        Assert.assertEquals("05",                       format6);
        Assert.assertEquals("01",                       format7);
        Assert.assertEquals("23",                       format8);
        Assert.assertEquals("2023",                     format9);
        Assert.assertEquals("01/05/23",                 format10);
        Assert.assertEquals("55",                       format11);
        Assert.assertEquals("05",                       format12);
        Assert.assertEquals("03",                       format13);
        Assert.assertEquals("15",                       format14);
        Assert.assertEquals("PM",                       format15);
        Assert.assertEquals("03:05:55 PM",              format16);
        Assert.assertEquals("01/05/23",                 format17);
        Assert.assertEquals("15:05:55",                 format18);
        Assert.assertEquals("Thr Jan 05 15:05:55 2023", format19);
        Assert.assertEquals("4",                        format20);
        Assert.assertEquals("Eastern Time",             format21);
        Assert.assertEquals("5",                        format22);
        Assert.assertEquals("1",                        format23);
    }
}