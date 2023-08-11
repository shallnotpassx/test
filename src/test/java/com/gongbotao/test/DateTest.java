package com.gongbotao.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;

/**
 * @author Wave
 * @version v 0.1 2018/11/28 11:17
 */
public class DateTest {

    @Test
    public void dateTest() {
        DateTime now = new DateTime("2020-05-20T00:00:00", DateTimeZone.UTC);

        System.out.println(now.getMillis());
    }

    @Test
    public void millisToDate() {
        DateTime date = new DateTime(1560318816000L);
        System.out.println(date.toString());
    }


    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
        long currTime = System.currentTimeMillis();
        //long dur = 511615511;
        long dur = 511615800;
        //as date record will expire, in seconds from Jan 01 2010 00:00:00 GMT
        long asExpFrom = 1262275200000l;
        long result = dur * 1000 + asExpFrom - currTime;
        Date date = new Date(dur * 1000 + asExpFrom + 8 * 3600 * 1000);
        System.out.println(sdf.format(date));
    }

    @Test
    public void testDistance() {
        Double d = Double.valueOf("1684288947000");
        System.out.println(daysBetween(d, new DateTime("2023-07-20").toDate()));
    }

    public static Long daysBetween(Object startDate, Object endDate) {
        Long millis = getTimeDistance(startDate, endDate);

        if (null == millis) {
            return null;
        }
        return millis / 24 / 60 / 60 / 1000;
    }

    /**
     * 方法名：时间差----计算第一个日期参数与第二个日期参数的事件差值，转换成毫秒整型值计算，取计算结果绝对值 入参obj1：日期时间 入参obj2：日期时间
     */
    public static Long getTimeDistance(Object obj1, Object obj2) {
        if (obj1 == null || "".equals(obj1) || obj2 == null || "".equals(obj2)) {
            return null;
        }

        long time1 = 0, time2 = 0;
        java.text.SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat sdf2 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (obj1 instanceof Date) {
            time1 = ((Date) obj1).getTime();
        } else if (obj1 instanceof Long) {
            time1 = (Long) obj1;
        } else if (obj1 instanceof Double) {
            time1 = ((Double) obj1).longValue();
        } else {
            try {
                time1 = Long.parseLong(obj1.toString());
            } catch (Exception e) {
                try {
                    time1 = sdf2.parse(obj1.toString()).getTime();
                } catch (java.text.ParseException ex) {
                    try {
                        time1 = sdf1.parse(obj1.toString()).getTime();
                    } catch (java.text.ParseException exc) {
                        exc.printStackTrace();
                    }
                }
            }
        }

        if (obj2 instanceof Date) {
            time2 = ((Date) obj2).getTime();
        } else if (obj2 instanceof Long) {
            time2 = (Long) obj2;
        } else if (obj2 instanceof Double) {
            time2 = ((Double) obj2).longValue();
        } else {
            try {
                time2 = Long.parseLong(obj2.toString());
            } catch (Exception e) {
                try {
                    time2 = sdf2.parse(obj2.toString()).getTime();
                } catch (java.text.ParseException ex) {
                    try {
                        time2 = sdf1.parse(obj2.toString()).getTime();
                    } catch (java.text.ParseException exc) {
                        exc.printStackTrace();
                    }
                }
            }
        }
        return Math.abs(time1 - time2);
    }
}
