package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Pizza;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alexander-ilkun
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:/appContext.xml"
})
//@ActiveProfiles(profiles = "prod")
//@Transactional ATJU4S supports it
//@Rollback
public class SimplePizzaServiceIT extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private PizzaService pizzaService;
    @PersistenceContext
    private EntityManager em;
    
    @Test
    public void testFind() {
        System.out.println("find");
        final String sql = "INSERT INTO pizzas (name, price, type) VALUES "
                + "('MARGARITA', 2.0, 'SEA')";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update(
                (Connection cnctn) -> cnctn.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS),
                keyHolder);
        Long id = keyHolder.getKey().longValue();
        Pizza result = pizzaService.find(id);
        
        System.out.println(result);
        assertEquals(result.getId(), id);
    }

    @Test
    public void testSave() {
        System.out.println("save");
        Pizza pizza = new Pizza();
        pizza.setName("Margarita");
        pizza.setType(Pizza.PizzaType.SEA);
        pizza.setPrice(2.0);
        
        Pizza result = pizzaService.save(pizza);
        em.flush();
        
        System.out.println(result.getId());
        assertNotNull(result.getId());
    }
}
