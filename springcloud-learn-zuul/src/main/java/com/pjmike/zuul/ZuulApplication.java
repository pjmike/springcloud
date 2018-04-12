package com.pjmike.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//声明一个zuul代理，该代，理使用Ribbon来定位注册在Eureka Server中的微服务上，同时
//该代理还整合了Hystrix是，实现了容错，所有经过Zuul的请求都会在Hystrix命令中执行
@EnableZuulProxy
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
