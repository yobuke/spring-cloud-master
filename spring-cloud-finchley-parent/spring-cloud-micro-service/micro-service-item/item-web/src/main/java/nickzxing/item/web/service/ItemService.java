package nickzxing.item.web.service;

import nickzxing.item.api.pojo.bo.ItemBO;

/**
 * @author NickZxing
 * @date 2019/1/28 15:42
 * Service
 */
public interface ItemService {

    ItemBO getById(Long id);
}
