package com.epam.balkashyn.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");


    public static Date createDateFromString(String dateString) {
        Date date;
        if (dateString != null) {
            try {
                date = DATE_FORMAT.parse(dateString);
            } catch (ParseException pe) {
                date = new Date();
            }
        } else {
            date = new Date();
        }
        return date;
    }
}
