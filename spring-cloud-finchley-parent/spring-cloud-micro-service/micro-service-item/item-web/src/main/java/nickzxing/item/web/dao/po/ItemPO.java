package nickzxing.item.web.dao.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author NickZxing
 * @date 2019/1/28 15:32
 * Persistent Object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "item_table")
public class ItemPO implements Serializable {

    private static final long serialVersionUID = -6069764851891587741L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String itemsn;

    @Column
    private String itemName;
}
