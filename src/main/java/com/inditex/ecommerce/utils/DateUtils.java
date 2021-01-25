package com.inditex.ecommerce.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.inditex.ecommerce.exception.ServiceException;
import com.inditex.ecommerce.exception.template.CommonErrorTemplate;
import com.inditex.ecommerce.exception.template.ErrorParameters;

public class DateUtils {

    private DateUtils() {
    }

    public static Date convertToDate(final String date) {
        Date ret;
        final SimpleDateFormat temp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            ret = temp.parse(date);
        } catch (ParseException e) {
            throw new ServiceException(null, CommonErrorTemplate.UNPARSEABLE_DATE, ErrorParameters.builder()
                .parameter("date", date)
                .build());
        }
        return ret;
    }
}
