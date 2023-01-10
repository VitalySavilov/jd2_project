package my.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_mark")
public class CarMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MARK_ID")
    private Long id;
    @Column(name = "MARK_NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carMark")
    @Builder.Default
    private List<CarModel> carModel = new ArrayList<>();
}
