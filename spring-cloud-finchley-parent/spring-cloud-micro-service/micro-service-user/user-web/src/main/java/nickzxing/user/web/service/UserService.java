package nickzxing.user.web.service;

import nickzxing.user.api.pojo.bo.UserBO;
import nickzxing.user.api.pojo.query.UserQuery;

import java.util.List;

/**
 * @author NickZxing
 * @date 2019/1/28 15:42
 * Service
 */
public interface UserService {

    UserBO getById(Long id);

    List<UserBO> listByQuery(UserQuery query);

    UserBO save(UserBO userBO);

    List<UserBO> batchSave(List<UserBO> userBOList);

    Integer deleteById(Long id);
}
