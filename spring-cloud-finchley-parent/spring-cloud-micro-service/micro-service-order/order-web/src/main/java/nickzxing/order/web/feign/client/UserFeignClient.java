package nickzxing.order.web.feign.client;

import nickzxing.order.web.feign.fallback.factory.UserFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import nickzxing.user.api.UserAPI;

/**
 * @author NickZxing
 * @date 2019/1/7 17:54
 */
@Component
//FeignClient的value值表示要调用的另一个微服务的实例名，这个值应该是另一个微服务的spring.application.name的值
//FeignClient调用另一个微服务的接口如果失败，则会执行UserFeignClientFallbackFactory.java类中的方法
@FeignClient(value = "micro-service-user", fallbackFactory = UserFeignClientFallbackFactory.class)
public interface UserFeignClient extends UserAPI {
}
