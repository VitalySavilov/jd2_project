package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.CarRepository;
import my.dto.CarFormDataDto;
import my.dto.CarCreateDto;
import my.dto.CarReadDto;
import my.mapper.CarCreateMapper;
import my.mapper.CarFormDataMapper;
import my.mapper.CarReadMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarFormDataMapper carFormDataMapper;
    private final CarReadMapper carReadMapper;
    private final CarCreateMapper carCreateMapper;

    @Transactional
    public void addCar(CarCreateDto carCreateDto) {
        carRepository.save(carCreateMapper.mapFrom(carCreateDto));
    }

    public Page<CarReadDto> getAll(Pageable pageable) {
        return carRepository.findAll(pageable).map(carReadMapper::mapFrom);
    }

    public long getCarCount() {
        return carRepository.count();
    }

    public CarFormDataDto getFormData(String actualMark) {
        return carFormDataMapper.getData(actualMark);
    }
}
