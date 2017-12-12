package com.kudin.alex.ecommerce.repositories;

import com.kudin.alex.ecommerce.models.Product;
import com.kudin.alex.ecommerce.services.Repositories;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by KUDIN ALEKSANDR on 10.12.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-context.xml"})
@WebAppConfiguration
public class JDBCStorageTest {

    @Autowired
    Repositories repos;

    private final Product p = new Product("test", "TEST", "Test", 78999L, "99.99", "This is a test product", true);

    @Test
    public void getProductById() throws Exception {
       int id = repos.springJDBC.addProduct(p);
       assertTrue(id > 0);

       Product prod = repos.jdbc.getProductById(id);

       assertEquals(id, prod.getId());
       assertEquals(p.getManufacturer(), prod.getManufacturer());
       assertEquals(p.getCategory(), prod.getCategory());
       assertEquals(p.getName(), prod.getName());
       assertEquals(p.getCode(), p.getCode());
       assertEquals(p.getPrice(), p.getPrice());
       assertEquals(p.getDescription(), p.getDescription());
       assertEquals(p.isFlag(), p.isFlag());

       assertTrue(repos.springJDBC.deleteProduct(id));
    }

}