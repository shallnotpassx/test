package com.gongbotao.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by Wave on 2019/11/7.
 */
public class JSONTest {

    @Test
    public void test() {
        System.out.println(buildStoreInfo("AMAZON_NA", "ASFDFASHDUIJASD", "N/A"));
    }

    private String buildStoreInfo(String platform, String sellerId, String storeUrl) {
        JSONObject storeInfo = new JSONObject();
        JSONArray storeArray = new JSONArray();
        JSONObject object = new JSONObject();
        object.put("storeId", platform + StringUtils.defaultString(sellerId, ""));
        object.put("storelink", storeUrl);
        storeArray.add(object);
        storeInfo.put("storeInfo", storeArray);
        return storeInfo.toJSONString();
    }

}
