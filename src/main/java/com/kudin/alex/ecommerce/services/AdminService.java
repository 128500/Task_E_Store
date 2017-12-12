package com.kudin.alex.ecommerce.services;

import com.kudin.alex.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * TODO add checking for the existing categories and manufacturers
 * Created by KUDIN ALEKSANDR on 07.12.2017.
 */

@Service
public class AdminService {

    private Repositories repos;

    @Autowired
    AdminService(final Repositories repositories){
        this.repos = repositories;
    }


    public boolean addManufacturer(String manufacturer) {
        String m = manufacturer.toUpperCase().trim();
        List<String> manufacturers = new ArrayList<>(repos.springJDBC.getAllManufacturers());
        if(manufacturer.contains(m)) return false;
        return m.length() >= 2 && repos.springJDBC.addManufacturer(m);
    }

    public boolean deleteManufacturer(String manufacturer){
        String m = manufacturer.toUpperCase().trim();
        return repos.springJDBC.deleteManufacturerWithProducts(m);
    }

    public Collection<String> getAllCategories(){
        return repos.springJDBC.getAllCategories();
    }


    public boolean addCategory(String category) {
        String c = category.toLowerCase().trim();
        List<String> categories = new ArrayList<>(repos.springJDBC.getAllCategories());
        if(categories.contains(c)) return false;
        return c.length() >= 2 && repos.springJDBC.addCategory(c);
    }


    public boolean deleteCategory(String category){
        String c = category.toLowerCase().trim();
        return repos.springJDBC.deleteCategoryWithAllProducts(c);
    }


    public Collection<String> getAllManufacturers(){
        return repos.springJDBC.getAllManufacturers();
    }

    public boolean addProduct(Product p){
        return repos.springJDBC.addProduct(p) > 0;
    }

    public Collection<Product> getAllProducts(){
        return repos.springJDBC.getAllProducts();
    }

    public Collection<String> getAllPrices(){
        return repos.springJDBC.getAllPrices();
    }

    public Product getProductById(int id){
        return repos.jdbc.getProductById(id);
    }

    public Collection<Product> getSpecificProducts(String manufacturer, String category, String price, boolean flag){
        return repos.springJDBC.getSpecificProducts(manufacturer, category, price, flag);
    }

    public boolean editProduct(Product p){
        return repos.springJDBC.editProductInfo(p);
    }

    public boolean deleteProduct(int id){
        return repos.springJDBC.deleteProduct(id);
    }
}
