package com.example.stgonline.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverterComponent {

    public static final Date tryConvertFromStringToDateWithTime(String dateStr){
        if(dateStr.isEmpty())return null;
        Date dateOfPayed = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            dateOfPayed = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            ...
        }
        return dateOfPayed;
    }

    public static final Date tryConvertFromStringToDate(String dateStr){
        
        ...

    }
}
