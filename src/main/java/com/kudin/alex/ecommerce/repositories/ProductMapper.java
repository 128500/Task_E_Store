package com.kudin.alex.ecommerce.repositories;

import com.kudin.alex.ecommerce.models.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ALEKSANDR KUDIN on 08.12.2017.
 */
public class ProductMapper implements RowMapper<Product> {

    public Product mapRow(ResultSet rs, int rowNum) throws SQLException{

        Product p = new Product();
        p.setId(rs.getInt("product_id"));
        p.setManufacturer(rs.getString("manufacturer"));
        p.setCategory(rs.getString("category"));
        p.setName(rs.getString("name"));
        p.setCode(rs.getLong("code"));
        p.setPrice(rs.getString("price"));
        p.setDescription(rs.getString("description"));
        p.setFlag(rs.getBoolean("flag"));
        return p;
    }
}
