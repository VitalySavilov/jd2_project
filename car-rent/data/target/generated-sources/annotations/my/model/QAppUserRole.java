package my.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAppUserRole is a Querydsl query type for AppUserRole
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAppUserRole extends EntityPathBase<AppUserRole> {

    private static final long serialVersionUID = 96284923L;

    public static final QAppUserRole appUserRole = new QAppUserRole("appUserRole");

    public final ListPath<AppUser, QAppUser> appUser = this.<AppUser, QAppUser>createList("appUser", AppUser.class, QAppUser.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QAppUserRole(String variable) {
        super(AppUserRole.class, forVariable(variable));
    }

    public QAppUserRole(Path<? extends AppUserRole> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAppUserRole(PathMetadata metadata) {
        super(AppUserRole.class, metadata);
    }

}

