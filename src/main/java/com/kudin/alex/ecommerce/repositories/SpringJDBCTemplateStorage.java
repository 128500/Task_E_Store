package com.kudin.alex.ecommerce.repositories;

import com.kudin.alex.ecommerce.models.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

/**
 * This class represents methods to store and retrieve
 * data to/from database via Spring (JdbcTemplate and
 * NamedParameterJdbcTemplate) framework
 *
 * Created by KUDIN ALEKSANDR on 06.12.2017.
 */
@Repository
public class SpringJDBCTemplateStorage implements Storage<Product>{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedTemplate;

    public void setNamedTemplate(NamedParameterJdbcTemplate namedTemplate) {
        this.namedTemplate = namedTemplate;
    }

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean addCategory(String category) {
        Object[] args = {category};
        String sql = "INSERT INTO categories(name) VALUES (?) RETURNING categories.category_id";
        int id  = jdbcTemplate.query(sql, args, resultSet -> {
            resultSet.next();
            return resultSet.getInt(1);
        });
        return (id > 0);
    }

    @Override
    public boolean deleteCategory(String category) {
        Object[] args = {category};
        String sql = "DELETE FROM categories AS c WHERE c.name = ?";
        int amount = jdbcTemplate.update(sql, args);
        return (amount > 0);
    }

    @Override
    public boolean deleteCategoryWithAllProducts(String category) {
        Object[] args = {category};
        String sql = "DELETE FROM categories AS c WHERE c.name = ?";
        int amount = jdbcTemplate.update(sql, args);
        String prodSql ="DELETE FROM products WHERE category = ?";
        jdbcTemplate.update(prodSql, args);
        return (amount > 0);
    }

    @Override
    public Collection<String> getAllCategories() {
        String sql = "SELECT categories.name FROM categories ORDER BY categories.name";
       return  this.jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public boolean addManufacturer(String manufacturer) {
        Object[] args = {manufacturer};
        String sql = "INSERT INTO manufacturers(name) VALUES (?) RETURNING manufacturers.m_id";
        int id  = jdbcTemplate.query(sql, args, resultSet -> {
            resultSet.next();
            return resultSet.getInt(1);
        });
        return (id > 0);
    }

    @Override
    public boolean deleteManufacturer(String manufacturer) {
        Object[] args = {manufacturer};
        String sql = "DELETE FROM manufacturers AS m WHERE m.name = ?";
        int count  = jdbcTemplate.update(sql, args);
        return (count > 0);
    }

    @Override
    public boolean deleteManufacturerWithProducts(String manufacturer) {
        Object[] args = {manufacturer};
        String sql = "DELETE FROM manufacturers AS m WHERE m.name = ?";
        int count  = jdbcTemplate.update(sql, args);
        String prodSql ="DELETE FROM products WHERE manufacturer = ?";
        jdbcTemplate.update(prodSql, args);
        return (count > 0);
    }

    @Override
    public Collection<String> getAllManufacturers() {
        String sql = "SELECT manufacturers.name FROM manufacturers ORDER BY manufacturers.name";
        return  this.jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public Collection<String> getAllPrices() {
        String sql = "SELECT products.price FROM products ORDER BY products.price";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public int addProduct(Product product) {
        int productId;
        Map<String,Object> pMap = createProductMap(product);
        String sql = "INSERT INTO products(manufacturer, category, name, code, price, description, flag) " +
                "VALUES (:manufacturer, :_category, :_name, :code, :price, :description, :flag) RETURNING products.product_id";
        productId = namedTemplate.query(sql, pMap, rs -> {
            if(rs.next()) return rs.getInt(1);
            else return 0;
        });
        return productId;
    }

    @Override
    public Product getProductById(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM products WHERE product_id = ?";
        try{
            return jdbcTemplate.query(sql, args, new ProductMapper()).iterator().next();
        } catch(NoSuchElementException e){
            System.out.print("No product with such id");
        }
        throw new IllegalStateException("No product with such id");
    }

    @Override
    public boolean editProductInfo(Product product) {
        Map<String,Object> pMap = createProductMap(product);
        String sql = "UPDATE products SET manufacturer = :manufacturer, category = :_category, name = :_name , code = :code, price = :price, description = :description, flag = :flag WHERE product_id = :id RETURNING *";
        int result = namedTemplate.query(sql, pMap, rs -> {
            if(rs.next()) return rs.getInt(1);
            else return 0;
        });
        return result > 0;
    }

    @Override
    public boolean deleteProduct(int id) {
        Object[] args = {id};
        String sql = "DELETE FROM products WHERE product_id = ? RETURNING *";
        int result = jdbcTemplate.query(sql, args, rs -> {
            if(rs.next()) return rs.getInt(1);
            else return 0;
        });
        return result > 0;
    }

    @Override
    public Collection<Product> getAllProducts() {
        String sql = "SELECT * FROM products";
         return jdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public Collection<Product> getSpecificProducts(String manufacturer, String category, String price, boolean flag) {
        ArrayList<Object> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM products AS p");
        if(!manufacturer.equals("all")){
            sql.append(" WHERE p.manufacturer = ?");
            list.add(manufacturer);
        }
        if(!category.equals("all")){
            if(sql.toString().contains("WHERE")) sql.append(" AND p.category = ?");
            else sql.append(" WHERE p.category = ?");
            list.add(category);
        }
        if(!price.equals("all")){
            if(sql.toString().contains("WHERE")) sql.append(" AND p.price = ?");
            else sql.append(" WHERE p.price = ?");
            list.add(price);
        }
        if(flag) {
            if(sql.toString().contains("WHERE")) sql.append(" AND p.flag = ?");
            else sql.append(" WHERE p.flag = ?");
            list.add(flag);
        }

        if(list.size() > 0) {
            Object[] args = new Object[list.size()];
            int i = 0;
            for(Object o : list){
                args[i] = o;
                i++;
            }
            return jdbcTemplate.query(sql.toString(), args, new ProductMapper());
        }
        return getAllProducts(); //no matches occurred for filters
    }


    /**
     * Maps the given Product entity to proceed
     * storing it in the database. Uses for
     * namedTemplate ({@see} org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate)
     *
     * @param product  - Product entity to store
     * @return map of Product entity
     */
    private Map<String, Object> createProductMap(Product product){
        Map<String, Object> pMap= new HashMap<>();
        pMap.put("id", product.getId());
        pMap.put("manufacturer", product.getManufacturer());
        pMap.put("_category", product.getCategory());
        pMap.put("_name", product.getName());
        pMap.put("code", product.getCode());
        pMap.put("price", product.getPrice());
        pMap.put("description", product.getDescription());
        pMap.put("flag", product.isFlag());
        return pMap;
    }
}
