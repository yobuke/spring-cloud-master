package nickzxing.user.api.pojo.vo;

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
public class UserVO implements Serializable {

    private static final long serialVersionUID = -8592188421852155642L;
    private Integer id;
    private String username;
}
