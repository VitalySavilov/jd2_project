package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.AppOrderRepository;
import my.dao.AppUserRepository;
import my.dao.CarRepository;
import my.dto.app_order.AppOrderEditDto;
import my.dto.app_order.AppOrderReadDto;
import my.dto.app_order.OrderStatus;
import my.dto.car.CarStatus;
import my.mapper.app_order.AppOrderReadMapper;
import my.model.AppOrder;
import my.model.AppUser;
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
    private final AppOrderReadMapper mapper;

    @Transactional
    public AppOrderReadDto createOrder(long carId, String user, long days) {
        AppUser appUser = appUserRepository.findAppUserByUsernameEquals(user).orElseThrow();
        Car car = carRepository.findCarById(carId).orElseThrow();
        car.setAvailable(CarStatus.UNAVAILABLE.isAvailable());
        AppOrder appOrder = appOrderRepository.save(AppOrder.builder()
                .appUser(appUser)
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(days)))
                .orderSum(car.getPrice() * days)
                .car(car)
                .build());
        return mapper.mapFrom(appOrder);
    }

    public Page<AppOrderReadDto> findAllOrders(Pageable pageable) {
        return appOrderRepository.findAll(pageable).map(mapper::mapFrom);
    }

    public AppOrderReadDto findOrder(long id){
        return mapper.mapFrom(appOrderRepository.findAppOrderById(id));
    }

    @Transactional
    public void updateOrder(long orderId, AppOrderEditDto appOrderEditDto) {
        AppOrder appOrder = appOrderRepository.findById(orderId).orElseThrow();
        Car car = carRepository.findCarById(appOrder.getCar().getId()).orElseThrow();
        if (!appOrderEditDto.getOrderStatus().isEmpty()){
            appOrder.setCompleted(OrderStatus.valueOf(appOrderEditDto.getOrderStatus()).isCompleted());
            car.setAvailable(OrderStatus.valueOf(appOrderEditDto.getOrderStatus()).isCompleted());
        }
    }
}
