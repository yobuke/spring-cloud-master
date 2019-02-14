package nickzxing.order.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * @author NickZxing
 * @date 2019/1/30 10:59
 * Spring配置类
 */
@Configuration
public class SpringConfiguration {

    /**
     * Spring Validation 开启方法级别验证
     *
     * @return
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
