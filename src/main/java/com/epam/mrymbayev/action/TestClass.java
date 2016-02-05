package com.epam.mrymbayev.action;

import com.epam.mrymbayev.util.Utilities;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestClass {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date date = simpleDateFormat.parse("09-05-2014", new ParsePosition(0));
//        System.out.println("calendar = " + );
        System.out.println("date = " + date);
    }
}
