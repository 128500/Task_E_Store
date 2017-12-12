package com.kudin.alex.ecommerce.controllers;

import com.kudin.alex.ecommerce.models.Product;
import com.kudin.alex.ecommerce.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This Class serves as Controller to handle the
 * requests from admin
 *
 * Created by KUDIN ALEKSANDR on 07.12.2017.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

   private AdminService aService;

   @Autowired
   AdminController(final AdminService adminService){
       this.aService = adminService;
   }


   @RequestMapping(value = "/homepage", method  = RequestMethod.GET)
    public String getAdminHomepage(){
       return "/admin/homepage";
   }


    @RequestMapping(value = "/add_manufacturer_page", method = RequestMethod.GET)
    public String getAddManufacturerPage(ModelMap model){
        model.addAttribute("manufacturers", aService.getAllManufacturers());
        return "/admin/add_manufacturer";
    }


   @RequestMapping(value = "/add_category_page", method = RequestMethod.GET)
    public String getAddCategoryPage(ModelMap model){
        model.addAttribute("categories", aService.getAllCategories());
        return "/admin/add_category";
   }

    @RequestMapping(value = "/add_manufacturer", method = RequestMethod.POST)
    public String addManufacturerPageAndRedirect(@RequestParam(value = "new_manufacturer") String manufacturer,
                                             ModelMap model){
        if(this.aService.addManufacturer(manufacturer)) return "redirect:/admin/homepage";
        else {
            model.addAttribute("manufacturer", manufacturer);
            return "/admin/failed";
        }
    }

    @RequestMapping(value = "/add_category", method = RequestMethod.POST)
    public String addCategoryPageAndRedirect(@RequestParam(value = "new_category") String category,
                                             ModelMap model){
        if(this.aService.addCategory(category)) return "redirect:/admin/homepage";
        else {
            model.addAttribute("category", category);
            return "/admin/failed";
        }
    }


    @RequestMapping(value = "/add_product_page", method = RequestMethod.GET)
    public String getAddProductPage(ModelMap model){
        model.addAttribute("manufacturers", aService.getAllManufacturers());
        model.addAttribute("categories", aService.getAllCategories());
        return "/admin/add_product";
    }

    @RequestMapping(value = "/add_product", method = RequestMethod.POST)
    public String addProduct(@RequestParam("manufacturer") String manufacturer,
                             @RequestParam("category") String category,
                             @RequestParam("name") String name,
                             @RequestParam("price") Float price,
                             @RequestParam("code") Long code,
                             @RequestParam("description") String description,
                             @RequestParam(value = "available", defaultValue = "false") boolean flag,
                             ModelMap model){
        Product p = new Product(manufacturer, category, name, code, String.valueOf(price), description, flag);
        if(aService.addProduct(p)) return "redirect:/admin/add_product_page";
        else{
            model.addAttribute("message", "PRODUCT" + name.toUpperCase());
            return "/admin/failed";
        }
    }


    @RequestMapping(value = "/edit_product_page", method = RequestMethod.GET)
    public String getEditProductPage(ModelMap model){
        model.addAttribute("products", aService.getAllProducts());
        model.addAttribute("categories", aService.getAllCategories());
        model.addAttribute("manufacturers", aService.getAllManufacturers());
        model.addAttribute("prices", aService.getAllPrices());
        return "/admin/view_all_products";
    }

    @RequestMapping(value = "/editing_product/{id}", method = RequestMethod.GET)
    public String addProduct(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("product", aService.getProductById(id));
        model.addAttribute("categories", aService.getAllCategories());
        model.addAttribute("manufacturers", aService.getAllManufacturers());
        return "/admin/edit_product";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editProduct(@PathVariable("id") int id,
                              @RequestParam("manufacturer") String manufacturer,
                              @RequestParam("category") String category,
                              @RequestParam("name") String name,
                              @RequestParam("price") Float price,
                              @RequestParam("code") Long code,
                              @RequestParam("description") String description,
                              @RequestParam(value = "available", defaultValue = "false") boolean flag,
                              ModelMap model){
        Product p = new Product(manufacturer, category, name, code, String.valueOf(price), description, flag);
        p.setId(id);
        if(aService.editProduct(p)) return "redirect:/admin/homepage";
        else{
            model.addAttribute("message", "PRODUCT" + name.toUpperCase());
            return "/admin/failed";
        }
    }

    @RequestMapping(value = "/see_detailed_info/{id}", method = RequestMethod.GET)
    public String getDetailedProductPage(@PathVariable("id") int id, ModelMap model){
        model.addAttribute("product", aService.getProductById(id));
        return "/admin/detailed_product_info";
    }

    @RequestMapping(value = "/specific_products", method = RequestMethod.POST)
    public String findSpecificProduct(@RequestParam("manufacturer") String manufacturer,
                                      @RequestParam("category") String category,
                                      @RequestParam("price") String price,
                                      @RequestParam(value = "available", defaultValue = "false") boolean flag,
                                      ModelMap model){
        model.addAttribute("products", aService.getSpecificProducts(manufacturer, category, price, flag));
        model.addAttribute("categories", aService.getAllCategories());
        model.addAttribute("manufacturers", aService.getAllManufacturers());
        model.addAttribute("prices", aService.getAllPrices());
        return "/admin/specific_products";
    }

    @RequestMapping(value = "/delete_product/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("id") int id, ModelMap model){
        if(aService.deleteProduct(id)) return "redirect:/admin/homepage";
        else{
            model.addAttribute("message", "PRODUCT with id: " + id);
            return "/admin/failed";
        }
    }

    @RequestMapping(value = "/delete_page", method = RequestMethod.GET)
    public String getDeletePage(ModelMap model){
        model.addAttribute("categories", aService.getAllCategories());
        model.addAttribute("manufacturers", aService.getAllManufacturers());
        return "/admin/delete_page";
    }

    @RequestMapping(value = "/delete_manufacturer/{name}", method = RequestMethod.GET)
    public String deleteManufacturer(@PathVariable("name") String name, ModelMap model){
        if(aService.deleteManufacturer(name)) return "redirect:/admin/homepage";
        else{
            model.addAttribute("message", "MANUFACTURER with name: " + name);
            return "/admin/failed";
        }
    }

    @RequestMapping(value = "/delete_category/{name}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable("name") String name, ModelMap model){
        if(aService.deleteCategory(name)) return "redirect:/admin/homepage";
        else{
            model.addAttribute("message", "CATEGORY with name: " + name);
            return "/admin/failed";
        }
    }
}
