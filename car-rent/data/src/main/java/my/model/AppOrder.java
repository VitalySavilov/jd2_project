package my.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

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
    @Column(name = "O_CAR_NUM")
    private String carNumber;
    @OneToOne(mappedBy = "appOrder")
    private Payment payment;
    @OneToOne
    @JoinColumn(name = "INFO_ID")
    private AppUserInfo appUserInfo;
}
