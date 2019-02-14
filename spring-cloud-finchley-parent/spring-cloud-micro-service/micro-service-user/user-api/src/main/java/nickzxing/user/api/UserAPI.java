package nickzxing.user.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import nickzxing.user.api.pojo.bo.UserBO;
import nickzxing.user.api.pojo.query.UserQuery;
import nickzxing.user.api.pojo.vo.UserVO;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author NickZxing
 * @date 2019/2/1 23:57
 * 用户接口
 * 1、其中字符串变量可供其他微服务调用时是用，避免直接输入接口地址
 * 2、类级注解@Validated适用于形参为基础数据包装类型时，例如Integer、Long、String等
 * 3、方法级别注解@Validated适用于形参为POJO时
 * 4、校验提示消息详见ValidationMessages.properties文件
 */
@RestController
@Validated
public interface UserAPI {

    String GET_BY_ID = "/user/get_by_id";
    String LIST_BY_QUERY = "/user/list_by_query";
    String SAVE = "/user/save";
    String BATCH_SAVE = "/user/batch_save";
    String DELETE_BY_ID = "/user/delete_by_id";

    @GetMapping(value = GET_BY_ID)
    UserVO getById(@RequestParam(value = "id", required = false) @NotNull(message = "{id.notNull}") Long id);

    @PostMapping(value = LIST_BY_QUERY)
    List<UserVO> listByQuery(@RequestBody UserQuery query);

    @PostMapping(value = SAVE)
    UserVO save(@RequestBody @Validated UserBO userBO);

    @PostMapping(value = BATCH_SAVE)
    List<UserVO> batchSave(@RequestBody @Validated List<UserBO> userBOList);

    @GetMapping(value = DELETE_BY_ID)
    Integer deleteById(@RequestParam(value = "id", required = false) @NotNull(message = "{id.notNull}") Long id);
}
