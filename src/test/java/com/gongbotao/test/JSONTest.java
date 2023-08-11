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


    @Test
    public void testGetArray() {
        String data = "[{\"ruleCode\":\" ubotest \",\"ruleId\":\"3sqr2ulqpc80 \",\"ruleName\":\" 规则测试\"}]";
        System.out.println(eval(data));
    }

    public String eval(String data) {
        String result = "";
        if (data != null) {
            try {
                JSONArray dataArray = JSONArray.parseArray(data);
                for (int i = 0; i < dataArray.size(); i++) {
                    JSONObject jsonObject = dataArray.getJSONObject(i);
                    String jsonResult1 = jsonObject.getString("ruleCode");
                    String jsonResult2 = jsonResult1.trim() + ",";
                    result = result + jsonResult2;
                }
                return result.substring(0, result.length() - 1);
            } catch (Exception e) {
            }
        }

        return result;
    }

}
