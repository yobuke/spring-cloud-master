package nickzxing.order.web.dao.po;

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
@Table(name = "order_table")
public class OrderPO implements Serializable {

    private static final long serialVersionUID = 5966978043451581488L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String ordersn;

    @Column
    private Long userId;
}
