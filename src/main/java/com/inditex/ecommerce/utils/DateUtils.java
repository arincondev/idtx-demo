package com.inditex.ecommerce.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static Date convertToDate(final String date) throws ParseException {
        final SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return temp.parse(date);
    }
}
