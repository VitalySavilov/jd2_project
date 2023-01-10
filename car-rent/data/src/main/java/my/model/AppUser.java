package my.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_user")
public class AppUser {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "USER_PASSWORD")
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INFO_ID")
    private AppUserInfo appUserInfo;
    @ManyToMany
    @JoinTable(name = "t_user_roles", joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "R_ID"))
    @Builder.Default
    private List<AppUserRole> roles = new ArrayList<>();
    @OneToMany(mappedBy = "appUser")
    @Builder.Default
    private List<AppOrder> orders = new ArrayList<>();
    @OneToMany(mappedBy = "appUser")
    @Builder.Default
    private List<PaymentCard> paymentCards = new ArrayList<>();
    @OneToMany(mappedBy = "appUser")
    private List<Payment> payments = new ArrayList<>();
}
