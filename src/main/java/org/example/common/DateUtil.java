package org.example.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String DATE_FORMAT = "dd/MM/yyyy";


    public static Date formatStrToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            return sdf.parse(str);
        }catch (Exception ex) {
            return null;
        }
    }

    public static boolean checkFormatDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        try {
            sdf.parse(str);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
