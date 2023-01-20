package my.mapper.app_order;

import my.dto.app_order.AppOrderDto;
import my.dto.app_order.OrderStatus;
import my.mapper.Mapper;
import my.model.AppOrder;
import org.springframework.stereotype.Component;

@Component
public class AppOrderDtoMapper implements Mapper<AppOrder, AppOrderDto> {
    @Override
    public AppOrderDto mapFrom(AppOrder object) {
        return new AppOrderDto(
                object.getId(),
                object.getStartDate(),
                object.getEndDate(),
                object.isCompleted() ? OrderStatus.COMPLETED.name() : OrderStatus.PROGRESS.name(),
                object.getOrderSum(),
                object.getCarNumber(),
                object.getAppUserInfo().getFirstname(),
                object.getAppUserInfo().getLastname(),
                object.getAppUserInfo().getBirthDate(),
                object.getAppUserInfo().getEmail(),
                object.getAppUserInfo().getTelNumber()
        );
    }
}
