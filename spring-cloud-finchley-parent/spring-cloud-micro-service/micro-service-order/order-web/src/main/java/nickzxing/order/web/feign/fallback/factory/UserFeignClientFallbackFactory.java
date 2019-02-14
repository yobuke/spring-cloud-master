package nickzxing.order.web.feign.fallback.factory;

import feign.hystrix.FallbackFactory;
import nickzxing.order.web.feign.client.UserFeignClient;
import nickzxing.user.api.pojo.bo.UserBO;
import nickzxing.user.api.pojo.query.UserQuery;
import nickzxing.user.api.pojo.vo.UserVO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author NickZxing
 * @date 2019/1/7 17:55
 * Feign调用失败时需要执行该类中的方法
 */
@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public UserVO getById(Long id) {
                return null;
            }

            @Override
            public List<UserVO> listByQuery(UserQuery query) {
                return null;
            }

            @Override
            public UserVO save(UserBO userBO) {
                return null;
            }

            @Override
            public List<UserVO> batchSave(List<UserBO> userBOList) {
                return null;
            }

            @Override
            public Integer deleteById(Long id) {
                return null;
            }
        };
    }
}
