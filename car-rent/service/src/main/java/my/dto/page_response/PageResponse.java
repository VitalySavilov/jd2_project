package my.dto.page_response;

import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;

@Value
public class PageResponse<T> {
    List<T> content;
    Metadata metadata;

    public static <T> PageResponse<T> of(Page<T> page) {
        Metadata md = new Metadata(
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
        return new PageResponse<>(page.getContent(), md);
    }

    @Value
    public static class Metadata {
        int page;
        int size;
        long totalElements;
        long totalPages;
    }
}
