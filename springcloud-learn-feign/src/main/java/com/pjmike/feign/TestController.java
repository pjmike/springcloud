package com.pjmike.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pjmike
 * @create 2018-04-03 18:49
 */
@RestController
public class TestController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/index")
    public String hello() {
        return userFeignClient.find();
    }
}
