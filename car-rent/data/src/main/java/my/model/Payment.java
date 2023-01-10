package my.model;

import lombok.*;

import javax.persistence.*;

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
    @Column(name = "P_SUM")
    private Double sum;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private AppUser appUser;
}