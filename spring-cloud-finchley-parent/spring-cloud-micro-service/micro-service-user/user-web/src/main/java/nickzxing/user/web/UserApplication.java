package nickzxing.user.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author NickZxing
 * @date 2019/1/21 16:10
 * 用户微服务启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@ComponentScans(value = {@ComponentScan(value = "nickzxing.user.web.config"),
        @ComponentScan(value = "uyun.whale.common.distributedcontext.config")})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
