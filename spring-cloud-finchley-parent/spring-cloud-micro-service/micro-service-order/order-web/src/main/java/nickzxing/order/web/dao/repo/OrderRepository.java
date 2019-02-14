package nickzxing.order.web.dao.repo;

import nickzxing.order.web.dao.po.OrderPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author NickZxing
 * @date 2019/1/7 15:50
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderPO, Serializable>, JpaSpecificationExecutor<OrderPO> {

    List<OrderPO> findByUserId(Long userId);
}
