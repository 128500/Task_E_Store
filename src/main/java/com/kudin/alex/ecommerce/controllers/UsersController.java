package com.kudin.alex.ecommerce.controllers;

import com.kudin.alex.ecommerce.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by KUDIN ALEKSANDR on 07.12.2017.
 */

@Controller
@RequestMapping("/users")
public class UsersController {

    private UsersService uService;

    @Autowired
    UsersController(UsersService usersService){
        this.uService = usersService;
    }

    @RequestMapping(value = "/homepage", method = RequestMethod.GET)
    public String getHomepage(){
        return "/users/homepage";
    }

    @RequestMapping(value = "/show_all_products", method = RequestMethod.GET)
    public String showAllProducts(ModelMap model){
        model.addAttribute("products", uService.getAllProducts());
        model.addAttribute("categories", uService.getAllCategories());
        model.addAttribute("manufacturers", uService.getAllManufacturers());
        model.addAttribute("prices", uService.getAllPrices());
        return "/users/show_all_products";
    }


    @RequestMapping(value = "/specific_products", method = RequestMethod.POST)
    public String findSpecificProduct(@RequestParam("manufacturer") String manufacturer,
                                      @RequestParam("category") String category,
                                      @RequestParam("price") String price,
                                      @RequestParam(value = "available", defaultValue = "false") boolean flag,
                                      ModelMap model){
        model.addAttribute("products", uService.getSpecificProducts(manufacturer, category, price, flag));
        model.addAttribute("categories", uService.getAllCategories());
        model.addAttribute("manufacturers", uService.getAllManufacturers());
        model.addAttribute("prices", uService.getAllPrices());
        return "/users/specific_product";
    }

    @RequestMapping(value = "/see_detailed_info/{id}", method = RequestMethod.GET)
    public String getDetailedProductPage(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("product", uService.getProductById(id));
        return "/users/detailed_prod_info";
    }
}
