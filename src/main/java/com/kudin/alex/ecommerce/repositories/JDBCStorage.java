package com.kudin.alex.ecommerce.repositories;

import com.kudin.alex.ecommerce.models.Product;
import com.kudin.alex.ecommerce.settings.Settings;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Collection;

/**
 *This class represents methods to store and retrieve
 * data to/from database via java database connection (JDBC)
 * It uses class {@see} Settings to get the properties
 * ({@see} resources/estore.properties) it needs to get
 * connection to the database
 *
 * Created by KUDIN ALEKSANDR on 06.12.2017.
 */

@Repository
public class JDBCStorage implements Storage<Product> {

    private final static JDBCStorage INSTANCE = new JDBCStorage();
    private Connection connection = null;


    private JDBCStorage() {
        Settings settings = Settings.getInstance();
        try {

            Class.forName(settings.getValue("jdbc.driver_class"));
            this.connection = DriverManager.getConnection(settings.getValue("jdbc.url"),
                    settings.getValue("jdbc.username"), settings.getValue("jdbc.password"));
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static JDBCStorage getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public Product getProductById(int id) {
        try(PreparedStatement statement =
                    this.connection.prepareStatement("SELECT * FROM products WHERE product_id = ?")){

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            Product p;
            if(rs.next()) {
                p = new ProductMapper().mapRow(rs, rs.getFetchSize()); /**{@see} ProductMapper.class*/
                rs.close();
                return p;
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }

        throw new IllegalStateException("Cannot find the product with such ID!");
    }

    @Override
    public boolean editProductInfo(Product product) {
        return false;
    }


    /** Not implemented yet
     * @see SpringJDBCTemplateStorage
     */
    @Override
    public boolean addCategory(String category) {
        return false;
    }

    @Override
    public boolean deleteCategory(String category) {
        return false;
    }

    @Override
    public boolean deleteCategoryWithAllProducts(String category) {
        return false;
    }

    @Override
    public Collection<String> getAllCategories() {
        return null;
    }

    @Override
    public boolean addManufacturer(String manufacturer) {
        return false;
    }

    @Override
    public boolean deleteManufacturer(String manufacturer) {
        return false;
    }

    @Override
    public boolean deleteManufacturerWithProducts(String manufacturer) {
        return false;
    }

    @Override
    public Collection<String> getAllManufacturers() {
        return null;
    }

    @Override
    public Collection<String> getAllPrices() {
        return null;
    }

    @Override
    public int addProduct(Product product) {
        return 0;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public Collection<Product> getAllProducts() {
        return null;
    }

    @Override
    public Collection<Product> getSpecificProducts(String manufacturer, String category, String price, boolean flag) {
        return null;
    }
}
