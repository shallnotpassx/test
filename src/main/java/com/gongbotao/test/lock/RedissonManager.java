package com.gongbotao.test.lock;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;

public class RedissonManager {


    @Value("${redis.host}")
    private static String redisHost;
    @Value("${redis.port}")
    private static String redisPort;

    private static Config config = new Config();
    //声明redisso对象
    private static Redisson redisson = null;
    //实例化redisson
    static{
        config.useSingleServer().setAddress(redisHost+":"+redisPort);
        //得到redisson对象
        redisson = (Redisson) Redisson.create(config);

    }

    //获取redisson对象的方法
    public static Redisson getRedisson(){
        return redisson;
    }
}
