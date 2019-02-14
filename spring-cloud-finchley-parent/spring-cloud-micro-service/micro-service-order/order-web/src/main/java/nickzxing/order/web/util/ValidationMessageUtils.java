package nickzxing.order.web.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author NickZxing
 * @date 2019/1/10 15:13
 * 验证信息封装类
 */
@Data
public class ValidationMessageUtils implements Serializable {

    private static final long serialVersionUID = -3113396387223230067L;

    // 参数名
    private String arg;

    // 参数索引
    private Integer index;

    // 验证信息
    private String message;

}
