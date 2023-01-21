package my.service;

import my.DataConfig;
import my.dto.car.CarCreateDto;
import my.dto.car.CarReadDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ServiceConfig.class,
        DataConfig.class})
@Transactional
@TestPropertySource(value = "classpath:/test.jdbc.properties")
public class CarServiceTest {
    @Autowired
    CarService carService;

    @Test
    public void getCarCount() {
        assertEquals(12, carService.getCarCount());
    }

    @Test
    public void deleteCar() {
        long countBeforeDelete = carService.getCarCount();
        carService.deleteCar(1L);
        assertEquals(countBeforeDelete - 1, carService.getCarCount());
    }

    @Test
    public void getCarById() {
        CarReadDto carReadDto = carService.getCarById(1L);
        assertEquals(carReadDto.getRegNumber(), "53-35AA-7");
    }

    @Test
    public void create() {
        MultipartFile[] file = {};
        long countBeforeCreate = carService.getCarCount();
        CarCreateDto carCreateDto = new CarCreateDto(
                null,
                "KIA",
                "RIO",
                "SEDAN",
                null,
                "Red",
                "77-77TT-7",
                110L,
                "2020",
                "DIESEL",
                5.0,
                35.0,
                new ArrayList<>(),
                file);
        carService.create(carCreateDto);
        assertEquals(countBeforeCreate + 1, carService.getCarCount());
    }

    @Test
    public void updateCar() {
        MultipartFile[] file = {};
        CarCreateDto carCreateDto = new CarCreateDto(
                null,
                "SKODA",
                "OCTAVIA",
                "SEDAN",
                null,
                "White",
                "88-88HH-7",
                120L,
                "2021",
                "DIESEL",
                6.0,
                40.0,
                new ArrayList<>(),
                file);
        CarReadDto car = carService.getCarById(5);
        assertEquals(55.0, car.getPrice(), 0.0);
        carService.updateCar(5, carCreateDto);
        CarReadDto carAfterUpdate = carService.getCarById(5);
        assertEquals(40.0, carAfterUpdate.getPrice(), 0.0);
    }
}