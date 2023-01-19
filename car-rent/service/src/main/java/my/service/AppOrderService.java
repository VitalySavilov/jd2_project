package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.AppOrderRepository;
import my.dao.AppUserRepository;
import my.dao.CarRepository;
import my.dto.app_order.AppOrderDto;
import my.dto.app_order.AppOrderEditDto;
import my.dto.app_order.OrderStatus;
import my.dto.car.CarStatus;
import my.mapper.app_order.AppOrderDtoMapper;
import my.model.AppOrder;
import my.model.AppUser;
import my.model.AppUserInfo;
import my.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AppOrderService {
    private final AppOrderRepository appOrderRepository;
    private final AppUserRepository appUserRepository;
    private final CarRepository carRepository;
    private final AppOrderDtoMapper appOrderDtoMapper;

    @Transactional
    public AppOrderDto createOrder(long carId, String user, long days) {
        AppUser appUser = appUserRepository.findAppUserByUsernameEquals(user).orElseThrow();
        AppUserInfo appUserInfo = appUser.getAppUserInfo();
        Car car = carRepository.findCarById(carId).orElseThrow();
        car.setAvailable(CarStatus.UNAVAILABLE.isAvailable());
        AppOrder appOrder = appOrderRepository.save(AppOrder.builder()
                .appUserInfo(appUserInfo)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(days)))
                .orderSum(car.getPrice() * days)
                .carNumber(car.getRegNumber())
                .build());
        return appOrderDtoMapper.mapFrom(appOrder);
    }

    public Page<AppOrderDto> findAllOrders(Pageable pageable) {
        return appOrderRepository.findAll(pageable).map(appOrderDtoMapper::mapFrom);
    }

    public AppOrderDto findOrder(long id){
        return appOrderDtoMapper.mapFrom(appOrderRepository.findAppOrderById(id));
    }

    @Transactional
    public void updateOrder(long orderId, AppOrderEditDto appOrderEditDto) {
        AppOrder appOrder = appOrderRepository.findById(orderId).orElseThrow();
        Car car = carRepository.findCarByRegNumber(appOrder.getCarNumber()).orElseThrow();
        if (!appOrderEditDto.getOrderStatus().isEmpty()){
            appOrder.setCompleted(OrderStatus.valueOf(appOrderEditDto.getOrderStatus()).isCompleted());
            car.setAvailable(OrderStatus.valueOf(appOrderEditDto.getOrderStatus()).isCompleted());
        }
    }
}
