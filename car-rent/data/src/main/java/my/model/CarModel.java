package my.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_car_model")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "M_ID")
    private Long id;
    @Column(name = "M_NAME")
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MARK_ID")
    private CarMark carMark;
}

