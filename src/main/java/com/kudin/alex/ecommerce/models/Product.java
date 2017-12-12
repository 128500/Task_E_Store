package com.kudin.alex.ecommerce.models;

/**
 *
 *This class describes a  product entity
 *
 * Created by KUDIN ALEKSANDR on 06.12.2017.
 */
public class Product {


    /*Id of this product*/
    private int id;

    /* Manufacturer of this product */
    private String manufacturer;

    /* Type of this product */
    private String category;

    /* Name of this product */
    private String name;

    /* Code of a product modification */
    private long code;

    /* Price of a product */
    private String price; //no need to store it as a numeric value (we do not do any arithmetic operations)

    /* A short description of this product */
    private String description;

    /* A flag showing if this product is available in the estore at the moment*/
    private boolean flag;


    /*Constructors*/
    public Product(){};

    public Product(String manufacturer, String category, String name, long code, String price, String description, boolean flag) {
        this.manufacturer = manufacturer;
        this.category = category;
        this.name = name;
        this.code = code;
        this.price = price;
        this.description = description;
        this.flag = flag;
    }


    /* Getters and setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
