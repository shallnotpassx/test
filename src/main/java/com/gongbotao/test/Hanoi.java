package com.gongbotao.test;

/**
 * @author Wave
 * @version v 0.1 2021/7/20 21:09
 */
public class Hanoi {

    public static int count = 0;
    public static void main(String[] args) {
        hanoi(30, "s1", "s2", "s3");
        System.out.println("total move count: " + count);
    }

    //将n个横杠利用z从x挪到y
    private static void hanoi(int n, String x, String y, String z) {
        count = ++count;
        if (n == 1) {
            System.out.println("move " + n + " from " + x + " to " + y);
            return;
        }

        hanoi(n - 1, x, z, y);
        System.out.println("move " + n + " to " + y);
        hanoi(n - 1, z, y, x);
    }
}
