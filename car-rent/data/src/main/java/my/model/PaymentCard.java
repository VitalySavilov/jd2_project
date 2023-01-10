package my.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_payment_card")
public class PaymentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_CARD_ID", nullable = false)
    private Long id;
    @Column(name = "P_CARD_NUM")
    private String cardNumber;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private AppUser appUser;
}
