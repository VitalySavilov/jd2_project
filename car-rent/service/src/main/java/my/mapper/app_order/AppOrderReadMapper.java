package my.mapper.app_order;

import lombok.RequiredArgsConstructor;
import my.dto.app_order.AppOrderReadDto;
import my.dto.app_order.OrderStatus;
import my.mapper.Mapper;
import my.mapper.app_user.AppUserReadMapper;
import my.mapper.car.CarReadMapper;
import my.model.AppOrder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppOrderReadMapper implements Mapper<AppOrder, AppOrderReadDto> {
    private final CarReadMapper carReadMapper;
    private final AppUserReadMapper appUserReadMapper;

    @Override
    public AppOrderReadDto mapFrom(AppOrder object) {
        return new AppOrderReadDto(object.getId(),
                object.getStartDate(),
                object.getEndDate(),
                object.isCompleted() ? OrderStatus.COMPLETED.name() : OrderStatus.PROGRESS.name(),
                carReadMapper.mapFrom(object.getCar()),
                appUserReadMapper.mapFrom(object.getAppUser()),
                object.getOrderSum());
    }
}
