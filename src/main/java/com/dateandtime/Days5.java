package com.dateandtime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.TimeZone;

public class Days5 {
    public static void main(String[] args) {
//        LocalDate date =LocalDate.now().minusDays(5);
//        System.out.println(date);
        LocalDate date = LocalDate.now();
        System.out.println(date);

//        Calender cal = Calender.getInstance();
//        TimeZone
//        TimeZOne.getTimeZone("Europe/London");
//        cal.setTimeZone(tz);

//

        LocalDateTime localDateTimeBeforeDST = LocalDateTime.now();
        ZoneId uk = ZoneId.of("Europe/London");
        ZonedDateTime zonedDateTimeBeforeDST = localDateTimeBeforeDST.atZone(uk);
        ZonedDateTime zonedDateTimeAfterDST = zonedDateTimeBeforeDST.plus(10, ChronoUnit.DAYS);
        System.out.println(zonedDateTimeBeforeDST);
        System.out.println(zonedDateTimeAfterDST);

        Date date1 = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println(sdf.format(date1));




    }
}
