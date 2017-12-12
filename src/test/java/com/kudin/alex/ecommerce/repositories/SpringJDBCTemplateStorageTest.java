package com.kudin.alex.ecommerce.repositories;

import com.kudin.alex.ecommerce.models.Product;
import com.kudin.alex.ecommerce.services.Repositories;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by KUDIN ALEKSANDR on 11.12.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-context.xml"})
@WebAppConfiguration
public class SpringJDBCTemplateStorageTest {

    @Autowired
    Repositories repos;

    private final Product p = new Product("test", "TEST", "Test", 78999L, "99.99", "This is a test product", true);
    private final static String MARK = "all";
    private int id;

    @Before
    public void setUp(){
      id =  repos.springJDBC.addProduct(p);
    }

    @After
    public void tearDown(){
        repos.springJDBC.deleteProduct(id);
    }

    @Test
    public void addCategory() throws Exception {
        String  c = "test_category";
        assertTrue(repos.springJDBC.addCategory(c));
        List<String> categories =  new ArrayList<>(repos.springJDBC.getAllCategories());
        assertTrue(categories.contains(c));
        assertTrue(repos.springJDBC.deleteCategory(c));
    }

    @Test
    public void deleteCategory() throws Exception {
        String  c = "test";
        assertTrue(repos.springJDBC.addCategory(c));
        List<String> categories =  new ArrayList<>(repos.springJDBC.getAllCategories());
        assertTrue(categories.contains(c));
        assertTrue(repos.springJDBC.deleteCategory(c));
    }

    @Test
    public void deleteCategoryWithAllProducts() throws Exception {
        assertTrue(repos.springJDBC.addCategory(p.getCategory()));
        assertTrue(repos.springJDBC.deleteCategoryWithAllProducts(p.getCategory()));
        assertFalse(repos.springJDBC.getAllCategories().contains(p.getCategory()));
        List<Product> products  = new ArrayList<>(repos.springJDBC.getAllProducts());
        if(!products.isEmpty()){
            for (Product p  : products){
                assertTrue(p.getId() != id);
            }
        }
    }


    @Test
    public void getAllCategories() throws Exception {
        String c = "testing";
        assertTrue(repos.springJDBC.addCategory(c));
        assertFalse(repos.springJDBC.getAllCategories().isEmpty());
        assertTrue(repos.springJDBC.deleteCategory(c));
    }

    @Test
    public void addManufacturer() throws Exception {
        String  m = "test_manufacturer";
        assertTrue(repos.springJDBC.addManufacturer(m));
        List<String> manufacturers =  new ArrayList<>(repos.springJDBC.getAllManufacturers());
        assertTrue(manufacturers.contains(m));
        assertTrue(repos.springJDBC.deleteManufacturer(m));
    }

    @Test
    public void deleteManufacturer() throws Exception {
        String  m = "test_m";
        assertTrue(repos.springJDBC.addManufacturer(m));
        List<String> manufacturers =  new ArrayList<>(repos.springJDBC.getAllManufacturers());
        assertTrue(manufacturers.contains(m));
        assertTrue(repos.springJDBC.deleteManufacturer(m));
    }

    @Test
    public void deleteManufacturerWithProducts() throws Exception {
        assertTrue(repos.springJDBC.addManufacturer(p.getManufacturer()));
        assertTrue(repos.springJDBC.deleteManufacturerWithProducts(p.getManufacturer()));
        assertFalse(repos.springJDBC.getAllManufacturers().contains(p.getManufacturer()));
        List<Product> products  = new ArrayList<>(repos.springJDBC.getAllProducts());
        if(!products.isEmpty()){
            for (Product p  : products){
                assertTrue(p.getId() != id);
            }
        }
    }

    @Test
    public void getAllManufacturers() throws Exception {
        String m = "testing";
        assertTrue(repos.springJDBC.addManufacturer(m));
        assertFalse(repos.springJDBC.getAllManufacturers().isEmpty());
        assertTrue(repos.springJDBC.deleteManufacturer(m));
    }

    @Test
    public void getAllPrices() throws Exception {
        assertFalse(repos.springJDBC.getAllPrices().isEmpty());
    }

    @Test
    public void addProduct() throws Exception {
        assertTrue(repos.springJDBC.getProductById(id) != null);
    }

    @Test
    public void getProductById() throws Exception {
        assertTrue(repos.springJDBC.getProductById(id) != null);
    }

    @Test
    public void editProductInfo() throws Exception {
        Product p  = new Product("t", "t", "t", 1L, "0", "t", false);
        p.setId(id);
        assertTrue(repos.springJDBC.editProductInfo(p));
        Product prod = repos.springJDBC.getProductById(id);
        assertEquals(p.getId(), prod.getId());
        assertEquals(p.getManufacturer(), prod.getManufacturer());
        assertEquals(p.getCategory(), prod.getCategory());
        assertEquals(p.getName(), prod.getName());
        assertEquals(p.getCode(), prod.getCode());
        assertEquals(p.getPrice(), prod.getPrice());
        assertEquals(p.getPrice(), prod.getPrice());
        assertEquals(p.getDescription(), prod.getDescription());
        assertEquals(p.isFlag(), prod.isFlag());
    }

    @Test
    public void deleteProduct() throws Exception {
        assertTrue(repos.springJDBC.deleteProduct(id));
    }

    @Test
    public void getAllProducts() throws Exception {
        assertFalse(repos.springJDBC.getAllProducts().isEmpty());
    }

    @Test
    public void getSpecificProducts() throws Exception {
        List<Product> products = new ArrayList<>(repos.springJDBC.getSpecificProducts(p.getManufacturer(),MARK,MARK,false));
        assertFalse(products.isEmpty());
        List<Product> productz = new ArrayList<>(repos.springJDBC.getSpecificProducts("SomeString",MARK,MARK,false));
        assertTrue(productz.isEmpty());
    }

}