package com.kudin.alex.ecommerce.repositories;


import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by KUDIN ALEKSANDR on 06.12.2017.
 */

public interface Storage<T> {

    /**
     * Adds a category into the database
     * @param category - name of the category to add
     * @return true if added successfully, false if not
     */
    boolean addCategory(String category);

    /**
     * Deletes a category according to the given name
     * @param category - name of the category to delete
     * @return true if deleted successfully, false if not or there is no such category
     */
    boolean deleteCategory(String category);

    /**
     * Deletes a category with all products related to it according to the given name
     * @param category - name of the category to delete
     * @return true if deleted successfully, false if not or there is no such category
     */
    boolean deleteCategoryWithAllProducts(String category);

    /**
     * Retrieves from the database all categories of goods
     * @return a collection of names of the categories
     */
    Collection<String> getAllCategories();

    /**
     * Adds a manufacturer into the database
     * @param manufacturer - name of the manufacturer to add
     * @return true if added successfully, false if not
     */
    boolean addManufacturer(String manufacturer);

    /**
     * Deletes a manufacturer according to the given name
     * @param manufacturer - name of the manufacturer to delete
     * @return true if deleted successfully, false if not or there is no such manufacturer
     */
    boolean deleteManufacturer(String manufacturer);

    /**
     * Deletes a manufacturer with all products related to it according to the given name
     * @param manufacturer - name of the manufacturer to delete
     * @return true if deleted successfully, false if not or there is no such manufacturer
     */
    boolean deleteManufacturerWithProducts(String manufacturer);

    /**
     * Retrieves from the database all manufacturer
     * @return a collection of names of the manufacturers
     */
    Collection<String> getAllManufacturers();

    /**
     * Retrieves from the database all prices
     * @return a collection of prices values
     */
    Collection<String> getAllPrices();

    /**
     * Adds new product into the database
     * @param product - entity of the product to add
     * @return true if added successfully, false if not
     */
    int addProduct(T product);

    /**
     * Retrieves data of the product
     * according to the given id
     * @param id - id of the product to retrieve
     * @return a Product entity
     */
    T getProductById(int id);

    /**
     * Edits data of the existing Product
     * @param product Product entity according to which the data must be updated
     * @return true if updated successfully, false if not
     */
    boolean editProductInfo(T product);

    /**
     * Deletes data about a specific product
     * according to the given product id
     * @param id - id of the product to delete
     * @return true if the operation is successful, false if not
     */
    boolean deleteProduct(int id);

    /**
     * Retrieves data about all products
     * @return - a collection of Product entities
     */
    Collection<T> getAllProducts();

    /**
     * Retrieves data about products according to the given specification
     *
     * @param manufacturer - name of the manufacturer of the products
     * @param category - name of the category of the products
     * @param price - specific price to look for
     * @param flag  - specific flag of looking for the products currently available
     * @return - a collection of Product entities
     */
    Collection<T> getSpecificProducts(String manufacturer, String category, String price, boolean flag);



}
