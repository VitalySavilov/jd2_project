package my.mapper.app_order;

import lombok.RequiredArgsConstructor;
import my.dto.app_order.AppOrderDto;
import my.dto.app_order.OrderStatus;
import my.mapper.Mapper;
import my.mapper.app_user.AppUserMapper;
import my.mapper.car.CarReadMapper;
import my.model.AppOrder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppOrderDtoMapper implements Mapper<AppOrder, AppOrderDto> {
    private final CarReadMapper carReadMapper;
    private final AppUserMapper appUserMapper;
    @Override
    public AppOrderDto mapFrom(AppOrder object) {
        return new AppOrderDto(
                object.getId(),
                object.getStartDate(),
                object.getEndDate(),
                object.isCompleted() ? OrderStatus.COMPLETED.name() : OrderStatus.PROGRESS.name(),
                carReadMapper.mapFrom(object.getCar()),
                appUserMapper.mapFrom(object.getAppUser()),
                object.getOrderSum()
        );
    }
}
