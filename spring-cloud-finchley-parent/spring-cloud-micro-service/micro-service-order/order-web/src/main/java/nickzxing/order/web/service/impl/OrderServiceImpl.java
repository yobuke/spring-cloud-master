package nickzxing.order.web.service.impl;

import nickzxing.order.web.dao.repo.OrderRepository;
import nickzxing.order.api.pojo.bo.OrderBO;
import nickzxing.order.web.service.OrderService;
import nickzxing.order.web.util.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author NickZxing
 * @date 2019/1/28 16:15
 * Service implement
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderBO> getByUserId(Long userId) {
        return CopyUtils.copyList(orderRepository.findByUserId(userId), OrderBO.class);
    }
}
