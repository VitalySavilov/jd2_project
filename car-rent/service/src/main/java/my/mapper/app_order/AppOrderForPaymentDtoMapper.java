package my.mapper.app_order;

import lombok.RequiredArgsConstructor;
import my.dto.app_order.AppOrderDto;
import my.dto.app_order.AppOrderForPaymentDto;
import my.dto.app_order.OrderStatus;
import my.mapper.Mapper;
import my.mapper.app_user.AppUserMapper;
import my.mapper.car.CarMapper;
import my.mapper.car.CarReadMapper;
import my.model.AppOrder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppOrderForPaymentDtoMapper implements Mapper<AppOrder, AppOrderForPaymentDto> {
    private final CarMapper carMapper;
    private final AppUserMapper appUserMapper;
    @Override
    public AppOrderForPaymentDto mapFrom(AppOrder object) {
        return new AppOrderForPaymentDto(
                object.getId(),
                object.getStartDate(),
                object.getEndDate(),
                object.isCompleted() ? OrderStatus.COMPLETED.name() : OrderStatus.PROGRESS.name(),
                carMapper.mapFrom(object.getCar()),
                appUserMapper.mapFrom(object.getAppUser()),
                object.getOrderSum()
        );
    }
}
