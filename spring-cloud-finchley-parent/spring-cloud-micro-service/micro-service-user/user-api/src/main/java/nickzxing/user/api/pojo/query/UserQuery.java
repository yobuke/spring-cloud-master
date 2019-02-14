package nickzxing.user.api.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import nickzxing.user.api.pojo.query.basic.BasicQuery;

import java.io.Serializable;

/**
 * @author NickZxing
 * @date 2019/1/30 11:52
 * Query Object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserQuery extends BasicQuery implements Serializable {

    private static final long serialVersionUID = -4801205236189308917L;
    private String username;
    private String password;
}
