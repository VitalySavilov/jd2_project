package my;

import my.dao.CarRepository;
import my.dao.PaymentCardRepository;
import my.service.AppUserService;
import my.service.CarService;
import my.service.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ServiceConfig.class,
        DataConfig.class})
//@TestPropertySource(value = "classpath:/test.jdbc.properties")
public class CarServiceTest {

    @Autowired
    CarService targetObject;

    @Autowired
    AppUserService appUserService;

    @Autowired
    PaymentCardRepository paymentCardRepository;
    @Autowired
    CarRepository carRepository;

    @Test
    public void getCount() {
        int count = (int) targetObject.getCarCount();
    }


    @Test
    public void deleteUser() {
        appUserService.deleteUser("34a9dd28-69ae-4459-9c63-369804f76d61");
    }

    @Test
    public void deleteCard() {
        paymentCardRepository.deleteById(9l);
    }

    @Test
    public void deleteCar() {
        carRepository.deleteById(1l);
    }

}