package nickzxing.order.web.config;

import nickzxing.order.web.feign.interceptor.HeaderInterceptor;
import nickzxing.order.web.feign.strategy.FeignHystrixConcurrencyStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author NickZxing
 * @date 2019/1/15 15:28
 * Feign配置类
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public HeaderInterceptor headerInterceptor() {
        return new HeaderInterceptor();
    }

    @Bean
    public FeignHystrixConcurrencyStrategy requestAttributeHystrixConcurrencyStrategy() {
        return new FeignHystrixConcurrencyStrategy();
    }
}
