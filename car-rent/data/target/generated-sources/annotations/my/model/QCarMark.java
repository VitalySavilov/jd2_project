package my.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCarMark is a Querydsl query type for CarMark
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCarMark extends EntityPathBase<CarMark> {

    private static final long serialVersionUID = 1129465370L;

    public static final QCarMark carMark = new QCarMark("carMark");

    public final ListPath<CarModel, QCarModel> carModel = this.<CarModel, QCarModel>createList("carModel", CarModel.class, QCarModel.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QCarMark(String variable) {
        super(CarMark.class, forVariable(variable));
    }

    public QCarMark(Path<? extends CarMark> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarMark(PathMetadata metadata) {
        super(CarMark.class, metadata);
    }

}

