package nickzxing.item.web.service.impl;

import nickzxing.item.api.pojo.bo.ItemBO;
import nickzxing.item.web.dao.repo.ItemRepository;
import nickzxing.item.web.service.ItemService;
import nickzxing.item.web.util.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author NickZxing
 * @date 2019/1/28 16:15
 * Service implement
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public ItemBO getById(Long id) {
        return CopyUtils.copyBean(itemRepository.findById(id).get(), ItemBO.class);
    }
}
