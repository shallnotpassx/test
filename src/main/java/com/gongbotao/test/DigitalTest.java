package com.gongbotao.test;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Created by Wave on 2018/12/12.
 */
public class DigitalTest {

    @Test
    public void randomTest() {
        Random generator = new Random();
        System.out.println(generator.nextInt(0));
    }

    @Test
    public void rateConvertTest() {
        BigDecimal rate = new BigDecimal("0.005");
        System.out.println(convertRate(rate));
    }

    private String convertRate(BigDecimal rate) {
        DecimalFormat decimalFormat = new DecimalFormat("###.###");

        return decimalFormat.format(rate.multiply(new BigDecimal(100))) + "%";
    }

    @Test
    public void test() {
        BigDecimal i = new BigDecimal(5);
        for (int j = 1; j < 4321; j++) {
            i = i.multiply(new BigDecimal(5));
        }
        System.out.println(i);

        BigDecimal x = new BigDecimal(4);
        for (int y = 1; y < 5321; y++) {
            x = x.multiply(new BigDecimal(4));
        }
        System.out.println(x);
    }

}
