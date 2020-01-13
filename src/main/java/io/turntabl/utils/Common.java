package io.turntabl.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public static Date toDate(String dateString){
        try {
            return DATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
