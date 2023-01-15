package my.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAppUser is a Querydsl query type for AppUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAppUser extends EntityPathBase<AppUser> {

    private static final long serialVersionUID = -217696539L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAppUser appUser = new QAppUser("appUser");

    public final QAppUserInfo appUserInfo;

    public final StringPath id = createString("id");

    public final ListPath<AppOrder, QAppOrder> orders = this.<AppOrder, QAppOrder>createList("orders", AppOrder.class, QAppOrder.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final ListPath<PaymentCard, QPaymentCard> paymentCards = this.<PaymentCard, QPaymentCard>createList("paymentCards", PaymentCard.class, QPaymentCard.class, PathInits.DIRECT2);

    public final ListPath<AppUserRole, QAppUserRole> roles = this.<AppUserRole, QAppUserRole>createList("roles", AppUserRole.class, QAppUserRole.class, PathInits.DIRECT2);

    public final StringPath username = createString("username");

    public QAppUser(String variable) {
        this(AppUser.class, forVariable(variable), INITS);
    }

    public QAppUser(Path<? extends AppUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAppUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAppUser(PathMetadata metadata, PathInits inits) {
        this(AppUser.class, metadata, inits);
    }

    public QAppUser(Class<? extends AppUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.appUserInfo = inits.isInitialized("appUserInfo") ? new QAppUserInfo(forProperty("appUserInfo")) : null;
    }

}

