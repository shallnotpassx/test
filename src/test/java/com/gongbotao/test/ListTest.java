package com.gongbotao.test;

import com.alibaba.fastjson.JSONObject;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author Wave
 * @version v 0.1 2018/6/26 09:21
 */
public class ListTest {

    @Test
    public void stringSplitTest() {
        String s = "";

        JSONObject obj = JSONObject.parseObject(s);
        System.out.println(new DateTime(obj.getDate("checkDate")));
    }

    @Test
    public void dataTest() {
        System.out.println((2001 / 500));
    }

    @Test
    public void binaryTest() {
        System.out.println(0 | 4);
    }


    @Test
    public void splitTest() {
        String s = "asdas,";
        System.out.println(s.substring(0, s.length() - 1));
    }

    @Test
    public void decimalTest() {
        BigDecimal result = BigDecimal.ZERO;
        BigDecimal rate = new BigDecimal(1.00);
        BigDecimal feeRate = rate.divide(new BigDecimal(100), 6, RoundingMode.FLOOR);
        BigDecimal actualFeeRate = feeRate.add(new BigDecimal(0.002)).setScale(6, RoundingMode.FLOOR);
        BigDecimal expectReceiveRate = BigDecimal.ONE.subtract(actualFeeRate);
        result = result.add(new BigDecimal(456.78).multiply(expectReceiveRate)).setScale(6, RoundingMode.FLOOR);
        System.out.println(result);
    }

    @Test
    public void strTest() {
        int sequence = 0;

        for (int i = 0; i < 2000; i++) {
            String s = String.valueOf(sequence);
            String result = "000".substring(s.length()) + s;

            if (sequence++ >= 999) {
                sequence = 0;
            }
            System.out.println(result);
        }
    }

    @Test
    public void nullTest() {
        List<Teacher> list = new ArrayList<>();
        list.add(new Teacher());
        list.add(null);
        list.add(null);
        list.removeAll(Collections.singleton(null));
        System.out.println(list.toString());
    }

    @Test
    public void charTest() {
        int v = 17;
        System.out.println((17 & 4) == 4);
    }
    @Test
    public void listTest() {
        List<Teacher> teachers = Collections.emptyList();
        Map<String, Teacher> teacherMap = teachers.stream().collect(Collectors.toMap(Teacher::getName, record -> record));
        System.out.println(teacherMap.toString());
    }

    @Test
    public void sortTest() {
        List<Teacher> teachers = new ArrayList<>();
        Teacher t1 = new Teacher();
        t1.setAge(1);
        t1.setName("1");

        Teacher t2 = new Teacher();
        t2.setAge(2);
        t2.setName("2");

        Teacher t3 = new Teacher();
        t3.setAge(3);
        t3.setName("3");

        teachers.add(t2);
        teachers.add(t1);
        teachers.add(t3);

        List<Teacher> sorted = teachers.stream().sorted((o1, o2) -> o1.getAge() >= o2.getAge() ? 1 : -1).collect(Collectors.toList());
        System.out.println(sorted.toString());
    }

}
