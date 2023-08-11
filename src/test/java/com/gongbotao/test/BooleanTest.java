package com.gongbotao.test;

import org.junit.Test;

/**
 * @author gongbotao
 * @date 2022/10/24.
 */
public class BooleanTest {


    @Test
    public void test1() {
        boolean C = true;
        boolean T = true;
        boolean I = true;
        boolean B = true;
        boolean O = true;
        boolean M = true;
        boolean X = false;
        boolean Q = true;

        boolean result = I & T & C & B & ((O & M) | (X & Q));
        System.out.println(result);
    }

    @Test
    public void test() {
        Long result = isCorpNameConsisV2("东莞市托帕斯服饰有限公司", "Dongguan Topaz Clothing Co., LTD",
            "DongguanTopazCostumeCO.,Ltd");
        System.out.println(result);
    }

    public static Long isCorpNameConsisV2(String corpName, String autoTransEnName, String entEnName) {
        // 参数有一为空则返回0
        if (corpName == null
            || corpName.length() == 0
            || entEnName == null
            || entEnName.length() == 0
            || autoTransEnName == null
            || autoTransEnName.length() == 0) {
            return 0l;
        }
        /// 清洗名称
        String cleanCorpName =
            corpName
                .replace(".", "")
                .replace(",", "")
                .replace("'", "")
                .replace("\"", "")
                .replace("&", "")
                .replace(" ", "")
                .toLowerCase();

        String cleanEntEnName =
            entEnName
                .replace(".", "")
                .replace(",", "")
                .replace("'", "")
                .replace("\"", "")
                .replace("&", "")
                .replace(" ", "")
                .toLowerCase();

        String cleanAutoTransEnName =
            autoTransEnName
                .replace(".", "")
                .replace(",", "")
                .replace("'", "")
                .replace("\"", "")
                .replace("&", "")
                .replace(" ", "")
                .toLowerCase();

        if (cleanCorpName.contains(cleanEntEnName)
            || cleanEntEnName.contains(cleanCorpName)
            || cleanAutoTransEnName.contains(cleanEntEnName)
            || cleanEntEnName.contains(cleanAutoTransEnName)) {
            return 1l;
        } else {
            return 0l;
        }
    }
}
