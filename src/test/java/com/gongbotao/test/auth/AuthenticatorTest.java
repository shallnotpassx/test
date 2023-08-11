package com.gongbotao.test.auth;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AuthenticatorTest {

    @Test
    public void auth() {
        Authentication authentication = new Authentication();
        authentication.setUrl("/user/info/aaa");
        authentication.setMethod("GET");

        List<UmsAuthority> authorities = new ArrayList<>();
        authorities.add(genAuthority(2, "/user/aaa/*", "GET", 4));
//        authorities.add(genAuthority(3, "/test/info", "POST", 4));
//        authorities.add(genAuthority(4, "/test/info", "ANY", 4));
//        authorities.add(genAuthority(4, "/test/user/*", "ANY", 5));
//        authorities.add(genAuthority(2, "/test/user/*", "GET", 5));
        Assert.assertEquals(2, (int) Authenticator.auth(authentication, authorities));
//        authentication.setMethod("PATCH");
//        Assert.assertEquals(4, (int) Authenticator.auth(authentication, authorities));
//        authentication.setMethod("POST");
//        Assert.assertEquals(3, (int) Authenticator.auth(authentication, authorities));
//        authentication.setUrl("/test/user/info");
//        authentication.setMethod("POST");
//        Assert.assertEquals(4, (int) Authenticator.auth(authentication, authorities));
//        authentication.setUrl("/test/user/info");
//        authentication.setMethod("GET");
//        Assert.assertEquals(2, (int) Authenticator.auth(authentication, authorities));
    }

    private UmsAuthority genAuthority(int scope, String value, String method, int type) {
        UmsAuthority authority = new UmsAuthority();
        authority.setScope(scope);
        authority.setValue(value);
        authority.setMethod(method);
        authority.setType(type);
        return authority;
    }
}