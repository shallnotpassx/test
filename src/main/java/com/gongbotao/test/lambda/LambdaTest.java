package com.gongbotao.test.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * Created by Wave on 2019/5/20.
 */
public class LambdaTest {

    @Test
    public void collectTest() {
        List<Student> students = new ArrayList<>();

        students.add(Student.builder()
                .studentId("a")
                .name("张三")
                .sex("男")
                .dob(new DateTime("2000-01-01").toDate())
                .money(new BigDecimal("100.87"))
                .bookFee(new BigDecimal("800"))
                .build());
        students.add(Student.builder()
                .studentId("b")
                .name("李四")
                .sex("男")
                .dob(new DateTime("2000-01-02").toDate())
                .money(new BigDecimal("123.45"))
                .bookFee(new BigDecimal("800"))
                .build());
        students.add(Student.builder()
                .studentId("c")
                .name("王五")
                .sex("女")
                .dob(new DateTime("2000-01-01").toDate())
                .money(new BigDecimal("7894.15"))
                .bookFee(new BigDecimal("800"))
                .build());
        students.add(Student.builder()
                .studentId("d")
                .name("张三")
                .sex("女")
                .dob(new DateTime("1998-03-01").toDate())
                .money(new BigDecimal("78.45"))
                .bookFee(new BigDecimal("800"))
                .build());
        Map<String, List<Student>> sexMap = students.stream().collect(Collectors.groupingBy(Student::getSex));
        BigDecimal sum = sexMap.values()
                .stream()
                .flatMap(Collection::stream)
                .map(Student::getBookFee)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);

    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Student {

    private String studentId;
    private String name;
    private String sex;
    private Date dob;
    private BigDecimal money;
    private BigDecimal bookFee;
}