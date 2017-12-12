package com.kudin.alex.ecommerce.settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ALEKSANDR KUDIN on 08.11.2017.
 */
public class Settings {
    private static final Settings INSTANCE = new Settings();

    private final Properties properties = new Properties();

    private Settings(){
        try{
            properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("estore.properties").getFile()));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static Settings getInstance(){
        return INSTANCE;
    }

    public String getValue(String key){
        return this.properties.getProperty(key);
    }
}
