package nickzxing.user.api.pojo.query.basic;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @author NickZxing
 * @date 2019/1/10 10:47
 * 查询对象超类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasicQuery implements Serializable {

    private static final long serialVersionUID = 1;

    @Min(value = 0, message = "{basicQuery.page.min}")
    private Integer page = 0;

    @Min(value = 1, message = "{basicQuery.size.min}")
    private Integer size = 10;

    private String direction = "ASC";

    private String properties = "id";
}
