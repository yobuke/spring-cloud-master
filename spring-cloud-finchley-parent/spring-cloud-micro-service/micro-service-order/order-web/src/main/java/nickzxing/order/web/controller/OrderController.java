package nickzxing.order.web.controller;

import nickzxing.order.api.OrderAPI;
import nickzxing.order.api.pojo.vo.OrderVO;
import nickzxing.order.web.feign.client.UserFeignClient;
import nickzxing.order.web.service.OrderService;
import nickzxing.order.web.util.CopyUtils;
import nickzxing.user.api.pojo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uyun.whale.common.distributedcontext.context.DistributedContextHolder;

import java.util.List;

/**
 * @author NickZxing
 * @date 2019/1/28 16:09
 * Controller
 */
@Component
public class OrderController implements OrderAPI {

    @Autowired
    OrderService orderService;

    @Autowired
    UserFeignClient userFeignClient;

    /**
     * 通过用户ID查找订单信息，并通过Feign调用用户微服务接口检查用户是否存在
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public List<OrderVO> getByUserId(Long userId) throws Exception {
        DistributedContextHolder.setAttribute("test-order", "20190909");
        DistributedContextHolder.setAttribute("test-number", 2721361);
        DistributedContextHolder.setAttribute("test-bool", true);
        UserVO u = new UserVO();
        u.setId(001);
        u.setUsername("zhili");
        DistributedContextHolder.setAttribute("test-ojb", u);
        System.out.println("order service orderId:" + DistributedContextHolder.getAttribute("orderId"));


        //通过Feign调用用户微服务接口并获取用户信息
        UserVO userVO = userFeignClient.getById(userId);
        if (null == userVO) {
            throw new Exception("未找到用户信息");
        }

        return CopyUtils.copyList(orderService.getByUserId(userId), OrderVO.class);
    }
}
