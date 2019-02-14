package nickzxing.item.web.controller;

import nickzxing.item.api.ItemAPI;
import nickzxing.item.api.pojo.vo.ItemVO;
import nickzxing.item.web.service.ItemService;
import nickzxing.item.web.util.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author NickZxing
 * @date 2019/1/28 16:09
 * Controller
 */
@Component
public class ItemController implements ItemAPI {

    @Autowired
    ItemService itemService;

    public ItemVO getById(Long id) {
        return CopyUtils.copyBean(itemService.getById(id), ItemVO.class);
    }

}
