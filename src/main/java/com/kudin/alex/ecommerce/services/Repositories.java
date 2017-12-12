package com.kudin.alex.ecommerce.services;

import com.kudin.alex.ecommerce.repositories.JDBCStorage;
import com.kudin.alex.ecommerce.repositories.SpringJDBCTemplateStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KUDIN ALEKSANDR on 08.12.2017.
 */

@Service
public class Repositories {

    public final JDBCStorage jdbc;
    public final SpringJDBCTemplateStorage springJDBC;

    @Autowired
    public Repositories(final JDBCStorage jdbc, final SpringJDBCTemplateStorage springJDBC){
        this.jdbc = jdbc;
        this.springJDBC = springJDBC;
    }
}
