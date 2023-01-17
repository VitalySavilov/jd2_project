package my.service;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import my.dao.*;
import my.dto.car.CarCreateDto;
import my.dto.car.CarReadDto;
import my.dto.car.CarStatus;
import my.dto.car.EditCarDto;
import my.dto.filter.CarFilter;
import my.mapper.car.CarCreateMapper;
import my.mapper.car.CarReadMapper;
import my.mapper.car_image.CarImageCreateMapper;
import my.mapper.car_mark.CarMarkCreateMapper;
import my.mapper.car_model.CarModelCreateMapper;
import my.mapper.car_type.CarTypeCreateMapper;
import my.model.*;
import my.querydsl.QPredicates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static my.model.QCar.car;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMarkRepository carMarkRepository;
    private final CarModelRepository carModelRepository;
    private final CarTypeRepository carTypeRepository;
    private final CarReadMapper carReadMapper;
    private final CarMarkCreateMapper carMarkCreateMapper;
    private final CarModelCreateMapper carModelCreateMapper;
    private final CarTypeCreateMapper carTypeCreateMapper;
    private final CarImageCreateMapper carImageCreateMapper;
    private final CarCreateMapper carCreateMapper;

    @Transactional
    public void create(CarCreateDto carCreateDto) {
        CarMark carMark = carMarkRepository.findCarMarkByName(carCreateDto.getCarMark())
                .orElse(carMarkCreateMapper.mapFrom(carCreateDto));
        CarModel carModel = carModelRepository.findCarModelByName(carCreateDto.getCarModel())
                .orElse(carModelCreateMapper.mapFrom(carCreateDto));
        CarType carType = carTypeRepository.findCarTypeByName(carCreateDto.getType())
                .orElse(carTypeCreateMapper.mapFrom(carCreateDto));
        List<CarImage> images = carImageCreateMapper.mapFrom(carCreateDto);
        Car car = carCreateMapper.mapFrom(carCreateDto);
        carModel.setCarMark(carMark);
        car.setCarModel(carModel);
        car.setCarMark(carMark);
        car.setType(carType);
        car.setImages(images);
        carRepository.save(car);
    }

    @Transactional
    public void updateCar(long carId, EditCarDto editCarDto) {
        Car car = carRepository.findCarById(carId).orElseThrow();
        car.setPrice(editCarDto.getPrice());
        if ((CarStatus.AVAILABLE.name().equals(editCarDto.getStatus())
                && car.getOrders().stream().allMatch(AppOrder::isCompleted))
                || CarStatus.UNAVAILABLE.name().equals(editCarDto.getStatus())) {
            car.setAvailable(CarStatus.valueOf(editCarDto.getStatus()).isAvailable());
        }
    }

    public Page<CarReadDto> getAll(Pageable pageable, CarFilter filter) {
        Predicate predicate = QPredicates.builder()
                .add(filter.getMark(), car.carMark.name::containsIgnoreCase)
                .add(filter.getType(), car.type.name::containsIgnoreCase)
                .build();
        return carRepository.findAll(predicate, pageable).map(carReadMapper::mapFrom);
    }

    public CarReadDto getCarById(long id) {
        return carRepository.findById(id).map(carReadMapper::mapFrom).orElseThrow();
    }

    public long getCarCount() {
        return carRepository.count();
    }
}
