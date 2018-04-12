package com.pjmike.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author pjmike
 * @create 2018-03-29 14:48
 */
@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "fallBack")
    @RequestMapping(value = "/hystrix-demo", method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }
    public String fallBack() {
        return "fall back";
    }
}
