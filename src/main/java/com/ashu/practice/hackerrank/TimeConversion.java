package com.ashu.practice.hackerrank;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class TimeConversion {
    public static void main(String[] args) {
        System.out.println(timeConversion("-12:00:00AM"));
    }

    /**
     * Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
     *
     * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
     * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
     * @param s
     * @return
     */
    public static String timeConversion(String s) {
        // Write your code here
        DateFormat input = new SimpleDateFormat("hh:mm:ssa");
        DateFormat out = new SimpleDateFormat("HH:mm:ss");
        Date temporal = null;
        try {
            temporal = input.parse(s);
            return out.format(temporal);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
