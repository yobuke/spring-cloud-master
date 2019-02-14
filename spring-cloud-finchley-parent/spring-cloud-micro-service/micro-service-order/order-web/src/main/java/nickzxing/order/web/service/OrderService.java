package nickzxing.order.web.service;

import nickzxing.order.api.pojo.bo.OrderBO;

import java.util.List;

/**
 * @author NickZxing
 * @date 2019/1/28 15:42
 * Service
 */
public interface OrderService {

    List<OrderBO> getByUserId(Long userId);
}
