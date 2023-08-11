package com.gongbotao.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gongbotao
 * @date 2022/10/13.
 */
public class PiPatternUtil {

    public static void main() {
        PiPatternUtil util = new PiPatternUtil();
        System.out.println("result: " + util.getPiPattern("123123"));
        System.out.println("result: " + util.getPiPattern("ABC123"));
        System.out.println("result: " + util.getPiPattern("123ABC"));
        System.out.println("result: " + util.getPiPattern("ABC123ABC"));
        System.out.println("result: " + util.getPiPattern("123ABC123"));
        System.out.println("result: " + util.getPiPattern("123-ABC-123"));
        System.out.println("result: " + util.getPiPattern("ABC-ABC----啊"));
    }


    private int getLetterStart(String s) {
        int i = -1;
        Matcher matcher = Pattern.compile("[a-z]").matcher(s.toLowerCase());
        if (matcher.find()) {
            i = matcher.start();
        }
        return i;
    }

    private int getNumStart(String s) {
        int i = -1;
        Matcher matcher = Pattern.compile("[0-9]").matcher(s.toLowerCase());
        if (matcher.find()) {
            i = matcher.start();
        }
        return i;
    }

    public String getPiPattern(String contractNo) {
        if (contractNo == null || "".equals(contractNo)) {
            return "";
        }

        String lower = contractNo.toLowerCase();
        int letterStart = getLetterStart(lower);
        //没有字母，返回空
        if (letterStart < 0) {
            return "";
        }
        //没有数字，返回空
        int numStart = getNumStart(lower);
        if (numStart < 0) {
            return "";
        }

        //获取字母往后第一个数字出现的位置
        String left = lower.substring(letterStart);
        int leftNumStart = getNumStart(left);
        //如果剩下的没有数字，返回剩下的全部字符串
        if (leftNumStart < 0) {
            return left;
        } else {
            return lower.substring(letterStart, leftNumStart + letterStart);
        }
    }

    public static void main(String[] args) {
        System.out.println(getApplyChannel("3"));
    }

    public static long getApplyChannel(String originInviteCodeType) {
        if (originInviteCodeType == null || "4".equals(originInviteCodeType) || originInviteCodeType.length() == 0) {
            return 1l;
        } else if ("1".equals(originInviteCodeType) || "3".equals(originInviteCodeType)) {
            return 2;
        } else if ("5".equals(originInviteCodeType)) {
            return 3l;
        } else {
            return -1l;
        }
    }
}
