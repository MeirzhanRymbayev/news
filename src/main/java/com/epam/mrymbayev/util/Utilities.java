package com.epam.mrymbayev.util;

import com.epam.mrymbayev.util.exception.UtilException;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Utilities {

    private static final Logger log = Logger.getLogger(Utilities.class);


    public static Calendar getCalendarFromString(String date, String stringFormat) {
        Calendar result = Calendar.getInstance();
        try {
            SimpleDateFormat format = new SimpleDateFormat(stringFormat);
            Date parse = format.parse(date);
            result.setTime(parse);
        } catch (ParseException e) {
            log.error("Can't parse date");
            throw new UtilException(e);
        }
        return result;
    }

}
