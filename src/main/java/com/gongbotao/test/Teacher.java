package com.gongbotao.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Wave on 2019/1/15.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private String name;
    private Integer age;

}
