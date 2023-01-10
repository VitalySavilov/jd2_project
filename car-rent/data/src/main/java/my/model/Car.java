package my.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    private Long id;
    @Column(name = "C_PRICE")
    private Double price;
    @Column(name = "C_COLOR")
    private String color;
    @Column(name = "C_YEAR")
    private String year;
    @Column(name = "C_FUEL")
    @Enumerated(EnumType.STRING)
    private Fuel fuelType;
    @Column(name = "C_CONSUMPTION")
    private Double fuelConsumption;
    @Column(name = "C_POWER")
    private Long power;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "T_ID")
    private CarType type;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "M_ID")
    private CarModel carModel;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "MARK_ID")
    private CarMark carMark;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "C_ID")
    @Builder.Default
    private List<CarImage> images = new ArrayList<>();
    @OneToMany(mappedBy = "car")
    @Builder.Default
    private List<AppOrder> orders = new ArrayList<>();
}

