package nickzxing.item.api.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author NickZxing
 * @date 2019/1/28 15:32
 * Business Object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemBO implements Serializable {

    private static final long serialVersionUID = 4597705813377319989L;
    private Long id;

    @NotBlank(message = "{item.itemsn.notBlank}")
    private String itemsn;

    @NotBlank(message = "{item.itemName.notBlank}")
    private String itemName;
}
