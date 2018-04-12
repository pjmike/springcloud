package com.pjmike.refresh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pjmike
 * @create 2018-04-08 19:40
 */
@RestController
@RefreshScope
public class HelloController {
    @Value(("${profile}"))
    private String profile;

    @GetMapping("/profile")
    public String hello() {
        return this.profile;
    }
}
