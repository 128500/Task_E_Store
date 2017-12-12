package com.kudin.alex.ecommerce.services;

import com.kudin.alex.ecommerce.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

/**
 * Created by KUDIN ALEKSANDR on 07.12.2017.
 */

@Service
public class UsersService {

    private Repositories repos;

    @Autowired
    UsersService(final Repositories repositories) {
        this.repos = repositories;
    }


    public Collection<Product> getAllProducts(){
        return repos.springJDBC.getAllProducts();
    }

    public Collection<Product> getSpecificProducts(String manufacturer, String category, String price, boolean flag){
        return repos.springJDBC.getSpecificProducts(manufacturer, category, price, flag);
    }

    public Collection<String> getAllCategories(){
        return repos.springJDBC.getAllCategories();
    }

    public Collection<String> getAllManufacturers(){
        return repos.springJDBC.getAllManufacturers();
    }

    public Collection<String> getAllPrices(){
        return repos.springJDBC.getAllPrices();
    }

    public Product getProductById(int id){
        return repos.jdbc.getProductById(id);
    }

}
