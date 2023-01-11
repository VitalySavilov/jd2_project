package my.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCarModel is a Querydsl query type for CarModel
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCarModel extends EntityPathBase<CarModel> {

    private static final long serialVersionUID = 654091644L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCarModel carModel = new QCarModel("carModel");

    public final QCarMark carMark;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QCarModel(String variable) {
        this(CarModel.class, forVariable(variable), INITS);
    }

    public QCarModel(Path<? extends CarModel> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCarModel(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCarModel(PathMetadata metadata, PathInits inits) {
        this(CarModel.class, metadata, inits);
    }

    public QCarModel(Class<? extends CarModel> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.carMark = inits.isInitialized("carMark") ? new QCarMark(forProperty("carMark")) : null;
    }

}

