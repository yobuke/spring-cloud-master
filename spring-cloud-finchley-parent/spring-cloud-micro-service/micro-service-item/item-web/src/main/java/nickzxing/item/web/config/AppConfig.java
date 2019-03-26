package nickzxing.item.web.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;

/**
 * @author ivanyu
 */
@Configuration
@EnableApolloConfig(value = {"application.yml"}, order = 1)
public class AppConfig {

}
