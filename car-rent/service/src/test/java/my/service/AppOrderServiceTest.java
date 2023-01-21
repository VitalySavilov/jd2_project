package my.service;

import my.DataConfig;
import my.dto.app_order.AppOrderDto;
import my.dto.app_order.AppOrderEditDto;
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
public class AppOrderServiceTest {
    @Autowired
    AppOrderService appOrderService;

    @Test
    public void createOrder() {
        long countBefore = appOrderService.getAppOrderCount();
        appOrderService.createOrder(7, "petr", 1);
        assertEquals(countBefore + 1, appOrderService.getAppOrderCount());
    }

    @Test
    public void findOrder() {
        AppOrderDto appOrderDto = appOrderService.findOrder(4);
        assertEquals(appOrderDto.getFirstname(), "Pavel");
        assertEquals(appOrderDto.getLastname(), "Pavlov");
        assertEquals(appOrderDto.getStatus(), "COMPLETED");
    }

    @Test
    public void updateOrder() {
        AppOrderEditDto appOrderEditDto = new AppOrderEditDto("PROGRESS");
        AppOrderDto appOrderDtoBefore = appOrderService.findOrder(3);
        assertEquals(appOrderDtoBefore.getStatus(), "COMPLETED");
        appOrderService.updateOrder(3, appOrderEditDto);
        AppOrderDto appOrderDtoAfter = appOrderService.findOrder(3);
        assertEquals(appOrderDtoAfter.getStatus(), "PROGRESS");
    }

    @Test
    public void getAppOrderCount() {
        assertEquals(appOrderService.getAppOrderCount(), 7);
    }
}