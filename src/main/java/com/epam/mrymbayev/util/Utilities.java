package com.epam.mrymbayev.util;

import com.epam.mrymbayev.util.exception.UtilException;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Utilities {

    private static final Logger log = Logger.getLogger(Utilities.class);


    public static Date getDateFromString(String date, String stringFormat) {
        Date result;
        try {
            SimpleDateFormat format = new SimpleDateFormat(stringFormat);
            result = format.parse(date);
        } catch (ParseException e) {
            log.error("Error of date parsing");
            throw new UtilException(e);
        }
        return result;
    }

}
