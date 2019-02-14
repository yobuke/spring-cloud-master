package nickzxing.eureka.server.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author NickZxing
 * @date 2019/1/11 17:03
 * Spring Security配置
 */
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        在Spring Cloud Finchley及更高版本中，Eureka服务端在添加了Basic认证后需要关闭CSRF保护，否则Eureka客户端无法完成注册
        http.csrf().ignoringAntMatchers("/eureka/**");
        super.configure(http);
    }
}
