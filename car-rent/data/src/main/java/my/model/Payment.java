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
@Table(name = "t_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    private Long id;
    @Column(name = "P_DATE")
    private Date paymentDate;
    @ManyToOne
    @JoinColumn(name = "O_ID")
    private AppOrder appOrder;

}