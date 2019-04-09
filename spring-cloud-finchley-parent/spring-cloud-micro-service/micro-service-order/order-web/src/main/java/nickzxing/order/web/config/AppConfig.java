package nickzxing.order.web.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author ivanyu
 */
@Configuration
@EnableApolloConfig(value = {"application.yml"}, order = 1)
@RefreshScope
public class AppConfig {
}
