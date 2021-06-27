package com.gongbotao.test;

import com.alibaba.fastjson.JSONObject;
import org.joda.time.DateTime;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

}
