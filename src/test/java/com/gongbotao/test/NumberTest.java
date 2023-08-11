package com.gongbotao.test;

import org.junit.Test;

/**
 * @author gongbotao
 * @date 2023/7/26.
 */
public class NumberTest {

    @Test
    public void test() {
        System.out.println(multiplyAndCompare(null, 1.5d, 50000d));
        System.out.println(multiplyAndCompare(null, 1.5d, null));
        System.out.println(multiplyAndCompare(1000d, null, 50000d));
        System.out.println(multiplyAndCompare(30000d, 1.5d, null));
        System.out.println(multiplyAndCompare(40000d, 1.5d, 50000d));
        System.out.println(multiplyAndCompare(30000d, 1.5d, 50000d));

    }

    /**
     * 方法名：乘----计算两个数值相乘的结果 入参obj1：乘数，数值类型或能转化成数值的类型(数值字符串、集合) 入参obj2：被乘数，数值类型或能转化成数值的类型(数值字符串、集合)
     */
    public static double multiplyAndCompare(Object num1, Object num2, Object compareValue) {
        // 存在入参为空，则返回-1D
        double multiplyResult = 0;
        if (num1 != null && num2 != null) {
            double item1 = (Double) (num1);
            double item2 = (Double) (num2);
            multiplyResult = item1 * item2;
        }

        if (compareValue == null) {
            return multiplyResult;
        } else {
            double item3 = (Double) compareValue;
            return Math.max(multiplyResult, item3);
        }
    }
}
