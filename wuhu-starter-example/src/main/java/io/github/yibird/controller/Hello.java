package io.github.yibird.controller;

import cn.hutool.crypto.digest.BCrypt;
import io.github.yibird.starter.web.model.Resp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author zchengfeng
 * @Datetime 2025/8/6 14:50
 */
@RestController
public record Hello() {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/doLogin")
    public Resp<String> doLogin() {
        String hash = "$2a$10$LeqqMQQWC1T1zxg2F0QTaO2PFZZFvOADJW7zt/GdGkhk3Nk.KT7ni";
        if (BCrypt.checkpw("123456", hash)) {
            System.out.println("123456");
        }
        return Resp.ok("ok");
    }
}
