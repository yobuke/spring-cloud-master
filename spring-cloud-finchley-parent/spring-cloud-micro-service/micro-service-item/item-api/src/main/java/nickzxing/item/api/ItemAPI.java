package nickzxing.item.api;

import nickzxing.item.api.pojo.vo.ItemVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author NickZxing
 * @date 2019/2/1 23:57
 * 订单接口
 * 1、其中字符串变量可供其他微服务调用时是用，避免直接输入接口地址
 * 2、类级注解@Validated适用于形参为基础数据包装类型时，例如Integer、Long、String等
 * 3、方法级别注解@Validated适用于形参为POJO时
 * 4、校验提示消息详见ValidationMessages.properties文件
 */
@RestController
@Validated
public interface ItemAPI {

    String GET_BY_ID = "/item/get_by_id";

    @GetMapping(value = GET_BY_ID)
    ItemVO getById(@RequestParam(value = "id", required = false) @NotNull(message = "{id.notNull}") Long id) throws Exception;
}
