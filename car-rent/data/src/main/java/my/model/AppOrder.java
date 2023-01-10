package my.model;

import lombok.*;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(name = "C_ID")
    private Car car;
}
