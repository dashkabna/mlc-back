
package mn.nomin.demo.entities;

import mn.nomin.demo.core.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "tasks")
@Data
@Entity
public class Task extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column()
    private String description;
}
