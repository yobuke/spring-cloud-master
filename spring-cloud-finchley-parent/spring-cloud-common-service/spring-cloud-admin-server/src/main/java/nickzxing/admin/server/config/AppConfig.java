package nickzxing.admin.server.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * @author ivanyu
 */
@Configuration
@EnableApolloConfig(value = {"application.yml"}, order = 1)
public class AppConfig {
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
