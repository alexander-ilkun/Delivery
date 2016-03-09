package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.User;
import com.ilkun.delivery.domain.Order;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author alexander-ilkun
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/appContext.xml",
    "classpath:/repositoryTestContext.xml"
})
public class SimpleOrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService customerService;
    
    @Test
    public void testPlaceNewOrder() {
        System.out.println("placeNewOrder");
        User customer = customerService.find(1L);
        Long[] pizzasID = {1l};
        Integer[] pizzasNumber = {1};

        Order result = orderService.placeNewOrder(customer, pizzasID, pizzasNumber);
        System.out.println(result);
        assertNotNull(result);
    }
}
