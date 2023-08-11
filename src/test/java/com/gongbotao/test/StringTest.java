package com.gongbotao.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

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

    @Test
    public void testUUID() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        System.out.println(replace);
    }

    @Test
    public void randomNumCodeTest() {
        System.out.println(RandomStringUtils.random(6, true, true).toLowerCase());
    }

    @Test
    public void convertTest() {
        Integer i = null;
        System.out.println(String.valueOf(i));
    }

    @Test
    public void test1() {
        System.out.println(getUBOMinAge(null));
        System.out.println(getUBOMinAge("|@||@|1984-03-19"));
        System.out.println(getUBOMinAge("|@|"));
        System.out.println(getUBOMinAge("2015-05-22|@|2006-12-31"));
        System.out.println(getUBOMinAge("2004-02-15"));
    }

    public static Long getUBOMinAge(String UBOdob) {
        if (UBOdob == null || UBOdob.length() == 0) {
            return 19L;
        } else {
            Long minAge = 999L;
            for (String uboDob : UBOdob.split("\\|@\\|")) {
                if (uboDob.length() != 10) {
                    continue;
                } else {
                    java.text.SimpleDateFormat ft = new java.text.SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date end = new java.util.Date();
                    try {
                        java.util.Date begin = ft.parse(uboDob);
                        double tmp_age =
                            Math.floor(((end.getTime() - begin.getTime()) / (24 * 60 * 60 * 1000)) / 365);
                        Long age = Math.round(tmp_age);
                        if (age < minAge) {
                            minAge = age;
                        }
                    } catch (java.text.ParseException e) {
                        minAge = 19L;
                    }
                }
            }
            return minAge == 999L ? 19L : minAge;
        }
    }

    @Test
    public void testSplice() {
        System.out.println(getStrFromSpliceStr(""));
        System.out.println(getStrFromSpliceStr(null));
        System.out.println(getStrFromSpliceStr("|@||@||@|"));
        System.out.println(getStrFromSpliceStr("|@||@||@|123"));
        System.out.println(getStrFromSpliceStr("123|@|345|@||@|123"));
        System.out.println(getStrFromSpliceStr("null|@|345|@||@|123"));
    }

    public static String getStrFromSpliceStr(String source) {
        if (source == null || source.length() == 0) {
            return "";
        }

        String[] strArr = source.split("\\|@\\|");
        boolean isAllEmpty = true;
        for (String s : strArr) {
            if (s != null && s.length() > 0) {
                isAllEmpty = false;
            }
        }

        return isAllEmpty ? "" : source;
    }

    @Test
    public void urlTest() {
        System.out.println(isUrlAli(null));
    }
    public static long isUrlAli(String url) {
        if (url == null || url.length() == 0) {
            return 0l;
        }
        if (url.contains("alibaba") && !url.contains("www.alibaba.com")) {
            return 1l;
        } else {
            return 0l;
        }
    }
    @Test
    public void test3() {
        System.out.println(isNotBlank(""));
        System.out.println(isNotBlank("1"));
        System.out.println(isNotBlank("null"));
        System.out.println(isNotBlank("1 234 "));
        System.out.println(isNotBlank(null));
        System.out.println(isNotBlank("    "));
    }

    public static boolean isNotBlank(String s) {
        int strLen;
        if (s == null || (strLen = s.length()) == 0) {
            return false;
        }

        for (int i = 0; i < strLen; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }


    @Test
    public void containsTest() {
        System.out.println(!isContainsStr("Raaaa", "RU"));
    }

    /** 方法名：是否包含字符串----判断第一个字符串参数中是否包含第二个字符串参数 入参str1：字符串 入参str2：字符串 */
    public static boolean isContainsStr(Object str1, Object str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        if (str2 instanceof String) {
            String minString = (String) str2;
            if (minString.startsWith("{") && minString.endsWith("}"))
                minString = minString.substring(1, minString.length() - 1);
            if (minString.startsWith("(") && minString.endsWith(")"))
                minString = minString.substring(1, minString.length() - 1);
            str2 = Arrays.asList(minString.split(","));

            if (minString.contains("|@|")) {
                String[] s = minString.split("\\|\\@\\|");
                str2 = Arrays.asList(s);
            }
            for (Object s2 : (Collection) str2) {
                if (s2 instanceof String
                    && str1 instanceof String
                    && ((String) str1).toLowerCase().contains(((String) s2).toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

}
