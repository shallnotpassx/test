package com.gongbotao.test.leetcode;

import org.junit.Test;

/**
 * Created by Wave on 2020/11/26.
 */
public class Leetcode {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        char[] s1 = String.valueOf(l1.val).toCharArray();
        char[] s2 = String.valueOf(l2.val).toCharArray();


//        int i1 = Integer.valueOf(.toString());
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void test() {
        System.out.println();
    }

}
