package my.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_app_order")
public class AppOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "O_ID")
    private Long id;
    @Builder.Default
    @Column(name = "O_IS_COMPLETED")
    private boolean isCompleted = false;
    @Column(name = "O_START")
    private Date startDate;
    @Column(name = "O_END")
    private Date endDate;
    @Column(name = "O_SUM")
    private Double orderSum;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(name = "C_ID")
    private Car car;
    @OneToMany(mappedBy = "appOrder")
    private List<Payment> payments;
}
