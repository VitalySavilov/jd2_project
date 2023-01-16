package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.CarTypeRepository;
import my.model.CarType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarTypeService {
    private final CarTypeRepository carTypeRepository;

    public List<String> getCarTypeNameList() {
        return carTypeRepository.findAll().stream()
                .map(CarType::getName)
                .collect(Collectors.toList());
    }
}
