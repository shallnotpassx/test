package com.gongbotao.test;

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.Test;

/**
 * @author gongbotao
 * @date 2022/11/10.
 */
public class MapTest {

    @Test
    public void test() {

        //                    "1650437403000": "INFG006",
        //                    "1667275812000": "INFG006",
        //                    "1652079541000": "INFG006",
        //                    "1650955963000": "INFG001,INFG007"

        Map<Date, String> map = new HashMap<>();
        map.put(new Date(1650437403000L), "INFG006");
        map.put(new Date(1667275812000L), "INFG006");
        map.put(new Date(1652079541000L), "INFG006");
        map.put(new Date(1650955963000L), "INFG001,INFG007");
        System.out.println(getFirstHitRulesDays(map, "INFG006"));
    }


    public static double getFirstHitRulesDays(Map map, String str) {

        double d = 0;
        if (map != null && map.size() > 0) {
            List list = new ArrayList();
            Iterator<Entry<Long, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Long, String> entry = it.next();
                if (entry.getValue().contains(str)) {
                    list.add(entry.getKey());
                }
            }
            if (list != null && list.size() > 0) {
                Collections.sort(list);
                long o = ((Date) list.get(0)).getTime();
                //long o = (Long) list.get(0);
                long now = new Date().getTime();
                d = (now - o) / (24 * 3600 * 1000);

                return d;
            }
            return d;
        }
        return d;
    }


    @Test
    public void mapTest() {
        List<Teacher> entityList = new ArrayList<>();
        Teacher t1 = new Teacher();
        t1.setName("a");
        t1.setAge(22);
        entityList.add(t1);

        Teacher t2 = new Teacher();
        t2.setName("a");
        t2.setAge(33);
        entityList.add(t2);

        Teacher t3 = new Teacher();
        t3.setName("b");
        t3.setAge(22);
        entityList.add(t3);

        Teacher t4 = new Teacher();
        t4.setName("b");
        t4.setAge(24);
        entityList.add(t4);

        Teacher t5 = new Teacher();
        t5.setName("a");
        t5.setAge(33);
        entityList.add(t5);

        Teacher t6 = new Teacher();
        t6.setName("c");
        t6.setAge(22);
        entityList.add(t6);

        Map<String, List<Integer>> nameCertNoMap = new HashMap<>();
        for (Teacher record : entityList) {
            List<Integer> certNoList;
            if (nameCertNoMap.containsKey(record.getName())) {
                certNoList = nameCertNoMap.get(record.getName());
                certNoList.add(record.getAge());
            } else {
                certNoList = new ArrayList<>();
                certNoList.add(record.getAge());
            }

            nameCertNoMap.put(record.getName(), certNoList);
        }

        System.out.println(JSONObject.toJSONString(nameCertNoMap));
    }
}
