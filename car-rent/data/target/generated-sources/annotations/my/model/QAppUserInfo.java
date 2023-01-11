package my.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAppUserInfo is a Querydsl query type for AppUserInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAppUserInfo extends EntityPathBase<AppUserInfo> {

    private static final long serialVersionUID = 96015667L;

    public static final QAppUserInfo appUserInfo = new QAppUserInfo("appUserInfo");

    public final DatePath<java.sql.Date> birthDate = createDate("birthDate", java.sql.Date.class);

    public final StringPath email = createString("email");

    public final StringPath firstname = createString("firstname");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastname = createString("lastname");

    public final StringPath telNumber = createString("telNumber");

    public QAppUserInfo(String variable) {
        super(AppUserInfo.class, forVariable(variable));
    }

    public QAppUserInfo(Path<? extends AppUserInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAppUserInfo(PathMetadata metadata) {
        super(AppUserInfo.class, metadata);
    }

}

