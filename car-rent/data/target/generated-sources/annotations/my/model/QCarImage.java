package my.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCarImage is a Querydsl query type for CarImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCarImage extends EntityPathBase<CarImage> {

    private static final long serialVersionUID = 650335150L;

    public static final QCarImage carImage = new QCarImage("carImage");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ArrayPath<byte[], Byte> image = createArray("image", byte[].class);

    public QCarImage(String variable) {
        super(CarImage.class, forVariable(variable));
    }

    public QCarImage(Path<? extends CarImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCarImage(PathMetadata metadata) {
        super(CarImage.class, metadata);
    }

}

