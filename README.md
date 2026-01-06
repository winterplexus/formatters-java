Formatters Library for Java
=================================
Formatters library based on Java 21 platform and contains classes for formatting objects into specific string representations.

Library includes the following components:

* BooleanFormats class
* DateTimeFormats class
* NumberFormats class

## BooleanFormats Class

```
public class BooleanFormats {
    public static String getLiteral(boolean condition) ...
    public static char getLiteralLetter(boolean condition) ...
}
```

## DateTimeFormats Class

```
public class DateTimeFormats {
    public String format(String specification, ZonedDateTime dt) ...
}
```

The date/time specifications are:

Specification | Description
------------- | -----------
%a | abbreviated weekday name
%A | full weekday name
%b | abbreviated month name
%B | full month name
%c | locale-specific date and time
%d | day of the month as integer (01-31)
%H | hour (24-hour clock)
%I | hour (12-hour clock)
%j | day of the year as integer (001-366)
%m | month as integer (01-12)
%M | minute as integer (00-59)
%p | locale AM/PM designation
%S | second as integer (00-59)
%w | weekday as integer (0-6)
%W | week number of the year (00-52)
%x | locale specific date
%X | locale specific time
%y | year without century (00-99)
%Y | year with century
%Z | time zone name
%% | a single %

## NumberFormats Class
```
public class NumberFormats {
    public static String getOrdinal(int n) ...
    public static String getLiteralAmount(double amount) ...
}
```
