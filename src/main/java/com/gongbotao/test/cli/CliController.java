package com.gongbotao.test.cli;

import com.gongbotao.test.util.RedissLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Wave on 2019/11/18.
 */
@Controller
@RequestMapping("/cli")
@Slf4j
public class CliController {

    private String lockName = "test";

    @GetMapping("/test/lock")
    @ResponseBody
    public String lockTest() {
        for (int i = 0; i < 10; i++) {
            final int serial = i;
            new Thread(() -> lock(serial)).start();
        }
        return "success";
    }

    private void lock(final int serial) {
        RLock lock = RedissLockUtil.lock(lockName);
        if (null != lock) {
            log.info("{} get lock success", serial);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            RedissLockUtil.unlock(lockName);
        } else {
            log.error("{} get lock failed", serial);
        }

    }
}
