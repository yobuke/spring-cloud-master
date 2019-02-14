package nickzxing.user.web.controller;

import nickzxing.user.api.UserAPI;
import nickzxing.user.api.pojo.bo.UserBO;
import nickzxing.user.api.pojo.query.UserQuery;
import nickzxing.user.api.pojo.vo.UserVO;
import nickzxing.user.web.service.UserService;
import nickzxing.user.web.util.CopyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author NickZxing
 * @date 2019/1/28 16:09
 * Controller
 */
@Component
public class UserController implements UserAPI {

    @Autowired
    UserService userService;

    public UserVO getById(Long id) {
        return CopyUtils.copyBean(userService.getById(id), UserVO.class);
    }

    public List<UserVO> listByQuery(UserQuery query) {
        return CopyUtils.copyList(userService.listByQuery(query), UserVO.class);
    }

    public UserVO save(UserBO userBO) {
        return CopyUtils.copyBean(userService.save(userBO), UserVO.class);
    }

    public List<UserVO> batchSave(List<UserBO> userBOList) {
        return CopyUtils.copyList(userService.batchSave(userBOList), UserVO.class);
    }

    public Integer deleteById(Long id) {
        return userService.deleteById(id);
    }

}
