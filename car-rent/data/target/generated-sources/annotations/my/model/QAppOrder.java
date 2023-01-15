package my.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAppOrder is a Querydsl query type for AppOrder
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAppOrder extends EntityPathBase<AppOrder> {

    private static final long serialVersionUID = 1835769716L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAppOrder appOrder = new QAppOrder("appOrder");

    public final QAppUser appUser;

    public final QCar car;

    public final DatePath<java.sql.Date> endDate = createDate("endDate", java.sql.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isCompleted = createBoolean("isCompleted");

    public final NumberPath<Double> orderSum = createNumber("orderSum", Double.class);

    public final ListPath<Payment, QPayment> payments = this.<Payment, QPayment>createList("payments", Payment.class, QPayment.class, PathInits.DIRECT2);

    public final DatePath<java.sql.Date> startDate = createDate("startDate", java.sql.Date.class);

    public QAppOrder(String variable) {
        this(AppOrder.class, forVariable(variable), INITS);
    }

    public QAppOrder(Path<? extends AppOrder> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAppOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAppOrder(PathMetadata metadata, PathInits inits) {
        this(AppOrder.class, metadata, inits);
    }

    public QAppOrder(Class<? extends AppOrder> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.appUser = inits.isInitialized("appUser") ? new QAppUser(forProperty("appUser"), inits.get("appUser")) : null;
        this.car = inits.isInitialized("car") ? new QCar(forProperty("car"), inits.get("car")) : null;
    }

}

