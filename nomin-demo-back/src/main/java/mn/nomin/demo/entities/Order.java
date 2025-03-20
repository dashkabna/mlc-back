
package mn.nomin.demo.entities;

import mn.nomin.demo.core.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "orders")
@Entity
@Data
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "user_id")
    private String userId;

    @Column(nullable = false, name = "total_price")
    private BigDecimal totalPrice;

    @Column(nullable = false, name = "order_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime orderDate = LocalDateTime.now();
}
