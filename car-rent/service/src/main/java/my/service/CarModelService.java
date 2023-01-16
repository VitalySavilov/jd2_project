package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.CarModelRepository;
import my.model.CarModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarModelService {
    private final CarModelRepository carModelRepository;

    public List<String> getActualModelList(String actualMark){
        return carModelRepository.findCarModelsByCarMarkName(actualMark).map(x -> x.stream()
                .map(CarModel::getName)
                .collect(Collectors.toList())).orElse(new ArrayList<>());
    }
}
