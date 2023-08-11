package com.gongbotao.test.auth;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

@Slf4j
public class Authenticator {

    public static Integer auth(Authentication auth, List<UmsAuthority> authorities) {

        int scope = -1;
        for (UmsAuthority userAction : authorities) {
            // 请求方法判断
            if (!auth.getMethod().equals(userAction.getMethod()) && !"ANY".equals(userAction.getMethod())) {
                continue;
            }
            boolean variableUrl = userAction.getValue().contains("*");
            // url判断
            if (!variableUrl && auth.getUrl().equals(userAction.getValue())) {
                scope = (scope < userAction.getScope() && scope >= 0) ? scope : userAction.getScope();
                continue;
            }
            if (variableUrl && PatternMatchUtils.simpleMatch(userAction.getValue(), auth.getUrl())) {
                scope = (scope < userAction.getScope() && scope >= 0) ? scope : userAction.getScope();
            }
        }
        if (scope == -1) {
            log.info("{} permission denied.", auth);
        }
        return scope;
    }

}
