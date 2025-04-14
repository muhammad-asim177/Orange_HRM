package com.OrangeHRM.utils;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static Properties initProperties() {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}