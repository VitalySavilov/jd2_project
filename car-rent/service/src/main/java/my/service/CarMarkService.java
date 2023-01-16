package my.service;

import lombok.RequiredArgsConstructor;
import my.dao.CarMarkRepository;
import my.model.CarMark;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CarMarkService {
    private final CarMarkRepository carMarkRepository;

    public List<String> getMarkNameList() {
        return carMarkRepository.findAll().stream()
                .map(CarMark::getName)
                .collect(Collectors.toList());
    }
}
