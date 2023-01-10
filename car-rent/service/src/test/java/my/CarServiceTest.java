package my;

import my.service.CarService;
import my.service.ServiceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ServiceConfig.class,
        DataConfig.class})
//@TestPropertySource(value = "classpath:/test.jdbc.properties")
public class CarServiceTest {

    @Autowired
    CarService targetObject;

    @Test
    public void getCount() {
        int count = (int) targetObject.getCarCount();
        assertEquals(4, count);
    }
}