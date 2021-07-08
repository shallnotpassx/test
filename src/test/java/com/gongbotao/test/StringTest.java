package com.gongbotao.test;

import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Wave on 2019/10/15.
 */
public class StringTest {

    List<String> names = Arrays.asList();

    @Test
    public void test() {
        System.out.println(StringUtils.isAllBlank("", null));
    }


    @Test
    public void splitTest() {
        names.forEach(name -> System.out.println(ToAnalysis.parse(name)));
    }

    @Test
    public void randomStringTest() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(100000, 888888));
        }
    }
}
