package com.gongbotao.test.beanMapper;

import com.gongbotao.test.Person;
import com.gongbotao.test.Staff;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * @author Wave
 * @version v 0.1 2021/8/16 20:59
 */
public class BeanUtilTest {

    @Test
    public void test() throws Exception {
        Person p1 = Person.builder()
            .name("张三")
            .age(11)
            .build();
        Staff s1 = new Staff();
        BeanUtils.copyProperties(p1, s1);
        System.out.println(s1);

        Staff s2 = new Staff();
        org.apache.commons.beanutils.BeanUtils.copyProperties(s2, p1);
        System.out.println(s2);
    }
}
