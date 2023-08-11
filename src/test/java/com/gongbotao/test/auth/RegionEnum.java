package com.gongbotao.test.auth;

import lombok.Getter;

public enum RegionEnum {
    CN(1, "中国"),
    EU(2, "欧洲"),
    US(3, "美国"),
    IN(4, "印度"),
    ;

    @Getter
    private int code;
    @Getter
    private String region;

    RegionEnum(int code, String region) {
        this.code = code;
        this.region = region;
    }
}
