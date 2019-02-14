package nickzxing.item.api.pojo.vo;

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
public class ItemVO implements Serializable {

    private static final long serialVersionUID = 5053150375056128818L;
    private Integer id;
    private String itemsn;
    private String itemName;
}
