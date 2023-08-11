package com.gongbotao.test.auth;

import java.util.List;
import lombok.Data;

@Data
public class UmsAuthority {

    private Long no;
    private Integer appId;
    private String name;
    private String value;
    private Integer type;
    private Integer order;
    private String method;
    private String divId;
    private List<UmsAuthority> subAuthorities;
    private Integer scope;
    private Integer region;

}
