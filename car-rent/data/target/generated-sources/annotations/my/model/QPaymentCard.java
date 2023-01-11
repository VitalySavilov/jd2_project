package my.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaymentCard is a Querydsl query type for PaymentCard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentCard extends EntityPathBase<PaymentCard> {

    private static final long serialVersionUID = -1925992689L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaymentCard paymentCard = new QPaymentCard("paymentCard");

    public final QAppUser appUser;

    public final StringPath cardNumber = createString("cardNumber");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QPaymentCard(String variable) {
        this(PaymentCard.class, forVariable(variable), INITS);
    }

    public QPaymentCard(Path<? extends PaymentCard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPaymentCard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPaymentCard(PathMetadata metadata, PathInits inits) {
        this(PaymentCard.class, metadata, inits);
    }

    public QPaymentCard(Class<? extends PaymentCard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.appUser = inits.isInitialized("appUser") ? new QAppUser(forProperty("appUser"), inits.get("appUser")) : null;
    }

}

