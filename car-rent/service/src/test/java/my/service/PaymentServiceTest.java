package my.service;

import my.DataConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        ServiceConfig.class,
        DataConfig.class})
@Transactional
@TestPropertySource(value = "classpath:/test.jdbc.properties")
public class PaymentServiceTest {
    @Autowired
    PaymentService paymentService;

    @Test
    public void createPayment() {
        long countBeforeCreate = paymentService.getPaymentCount();
        paymentService.createPayment(2);
        assertEquals(countBeforeCreate + 1, paymentService.getPaymentCount());
    }

    @Test
    public void deletePayment() {
        long countBeforeDelete = paymentService.getPaymentCount();
        paymentService.deletePayment(5);
        assertEquals(countBeforeDelete - 1, paymentService.getPaymentCount());
    }
}