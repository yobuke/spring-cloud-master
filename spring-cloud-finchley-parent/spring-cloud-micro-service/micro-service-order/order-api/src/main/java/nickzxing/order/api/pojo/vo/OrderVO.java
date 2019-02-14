package nickzxing.order.api.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author NickZxing
 * @date 2019/1/28 15:32
 * View Object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderVO implements Serializable {

    private static final long serialVersionUID = -4537162126504996545L;
    private Integer id;
    private String ordersn;
    private String username;
}
