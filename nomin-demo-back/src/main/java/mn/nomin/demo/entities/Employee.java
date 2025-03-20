
package mn.nomin.demo.entities;

import mn.nomin.demo.core.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Table(name = "employees")
@Entity
@Data
public class Employee extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 50)
    private String position;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal salary;
}
