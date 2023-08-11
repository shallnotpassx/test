package com.gongbotao.test.auth;

import lombok.Data;

@Data
public class Authentication {

    private Integer appId;
    private RegionEnum region;
    private String url;
    private String method;
    private String code;
}
