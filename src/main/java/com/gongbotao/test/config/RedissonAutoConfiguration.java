package com.gongbotao.test.config;

import com.gongbotao.test.lock.DistributedLocker;
import com.gongbotao.test.lock.RedissonDistributedLocker;
import com.gongbotao.test.util.RedissLockUtil;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class RedissonAutoConfiguration {


    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private String port;
    @Value("${redis.password}")
    private String password;


    /**
     * 单机模式自动装配
     */
    @Bean
    public RedissonClient redissonSingle() {
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
            .setAddress(host + ":" + port)
            .setTimeout(3000)
            .setConnectionPoolSize(64)
            .setConnectionMinimumIdleSize(10);

        if (StringUtils.isNotBlank(password)) {
            serverConfig.setPassword(password);
        }

        return Redisson.create(config);
    }

    /**
     * 装配locker类，并将实例注入到RedissLockUtil中
     */
    @Bean
    public DistributedLocker distributedLocker(RedissonClient redissonClient) {
        RedissonDistributedLocker locker = new RedissonDistributedLocker();
        locker.setRedissonClient(redissonClient);
        RedissLockUtil.setLocker(locker);
        return locker;
    }

}
