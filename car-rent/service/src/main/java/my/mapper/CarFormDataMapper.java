package my.mapper;

import lombok.RequiredArgsConstructor;
import my.dao.CarMarkRepository;
import my.dao.CarTypeRepository;
import my.dto.CarFormDataDto;
import my.model.CarMark;
import my.model.CarModel;
import my.model.CarType;
import my.model.Fuel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CarFormDataMapper {
    private final CarTypeRepository carTypeRepository;
    private final CarMarkRepository carMarkRepository;

    public CarFormDataDto getData(String actualMark) {
        actualMark = actualMark != null ? actualMark : "";
        return new CarFormDataDto(
                carMarkRepository.findAll().stream()
                        .map(CarMark::getName)
                        .collect(Collectors.toList()),
                carMarkRepository.findCarMarkByName(actualMark)
                        .map(CarMark::getCarModel)
                        .map(models -> models.stream()
                                .map(CarModel::getName)
                                .collect(Collectors.toList()))
                        .orElse(new ArrayList<>()),
                carTypeRepository.findAll().stream()
                        .map(CarType::getName)
                        .collect(Collectors.toList()),
                Arrays.stream(Fuel.values())
                        .map(Enum::name)
                        .collect(Collectors.toList()),
                actualMark
        );
    }
}
