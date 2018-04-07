package com.pjmike.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>@FeignClient注解用来指定任意一个服务提供者</p>
 * @author pjmike
 * @create 2018-04-03 18:50
 */
@FeignClient(name = "hello-service",
fallbackFactory = FeignClientFallBack.class)
public interface UserFeignClient {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String find();

}
@Component
class FeignClientFallBack implements FallbackFactory<UserFeignClient> {


    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public String find() {
                return "fall back";
            }
        };
    }
}