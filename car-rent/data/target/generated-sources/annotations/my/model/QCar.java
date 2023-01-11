package my.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCar is a Querydsl query type for Car
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCar extends EntityPathBase<Car> {

    private static final long serialVersionUID = 335833517L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCar car = new QCar("car");

    public final QCarMark carMark;

    public final QCarModel carModel;

    public final StringPath color = createString("color");

    public final NumberPath<Double> fuelConsumption = createNumber("fuelConsumption", Double.class);

    public final EnumPath<Fuel> fuelType = createEnum("fuelType", Fuel.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<CarImage, QCarImage> images = this.<CarImage, QCarImage>createList("images", CarImage.class, QCarImage.class, PathInits.DIRECT2);

    public final ListPath<AppOrder, QAppOrder> orders = this.<AppOrder, QAppOrder>createList("orders", AppOrder.class, QAppOrder.class, PathInits.DIRECT2);

    public final NumberPath<Long> power = createNumber("power", Long.class);

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final QCarType type;

    public final StringPath year = createString("year");

    public QCar(String variable) {
        this(Car.class, forVariable(variable), INITS);
    }

    public QCar(Path<? extends Car> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCar(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCar(PathMetadata metadata, PathInits inits) {
        this(Car.class, metadata, inits);
    }

    public QCar(Class<? extends Car> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.carMark = inits.isInitialized("carMark") ? new QCarMark(forProperty("carMark")) : null;
        this.carModel = inits.isInitialized("carModel") ? new QCarModel(forProperty("carModel"), inits.get("carModel")) : null;
        this.type = inits.isInitialized("type") ? new QCarType(forProperty("type")) : null;
    }

}

