package nickzxing.item.web.dao.repo;

import nickzxing.item.web.dao.po.ItemPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author NickZxing
 * @date 2019/1/7 15:50
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemPO, Serializable>, JpaSpecificationExecutor<ItemPO> {

}
