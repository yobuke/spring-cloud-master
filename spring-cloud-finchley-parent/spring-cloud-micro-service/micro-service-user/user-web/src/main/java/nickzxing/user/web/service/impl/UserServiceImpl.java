package nickzxing.user.web.service.impl;

import nickzxing.user.web.dao.repo.UserRepository;
import nickzxing.user.web.service.UserService;
import nickzxing.user.web.util.CopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import nickzxing.user.api.pojo.bo.UserBO;
import nickzxing.user.api.pojo.query.UserQuery;

import java.util.List;

/**
 * @author NickZxing
 * @date 2019/1/28 16:15
 * Service implement
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserBO getById(Long id) {
        return CopyUtils.copyBean(userRepository.findById(id).get(), UserBO.class);
    }

    @Override
    public List<UserBO> listByQuery(UserQuery query) {
        return null;
    }

    @Override
    public UserBO save(UserBO userBO) {
        return null;
    }

    @Override
    public List<UserBO> batchSave(List<UserBO> userBOList) {
        return null;
    }

    @Override
    public Integer deleteById(Long id) {
        return null;
    }
}
