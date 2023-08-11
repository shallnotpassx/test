package com.gongbotao.test.react;

import reactor.core.publisher.Flux;

/**
 * @author gongbotao
 * @date 2023/6/21.
 */
public class Test {

    public static void main(String[] args) {
        Flux.just("tom", "jack", "allen")
            .filter(s -> s.length() > 3)
            .map(s -> s.concat("@qq.com"))
            .subscribe(System.out::println);
    }
}
