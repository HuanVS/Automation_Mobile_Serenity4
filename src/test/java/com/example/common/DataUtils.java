package com.example.common;


import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DataUtils {
    public static final String PATH_RESOURCE;
    public static final String PATH_RESOURCE_DATA;
    public static final EnvironmentVariables ENV;

    public DataUtils() {
    }

    public static String getValueConf(String config) {
        return EnvironmentSpecificConfiguration.from(ENV).getProperty(config);
    }

    public static String getDataPropertiesFile(String nameConfig, String key) {
        Properties prop = new Properties();
        Map<String, String> map = new HashMap<>();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("src/test/resources/data" + File.separator + nameConfig);
            prop.load(inputStream);
            for (String variable : prop.stringPropertyNames()) {
                String value = prop.getProperty(variable);
                map.put(variable, value);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Some issue finding or loading file....!!! " + e.getMessage());
        }
        return map.get(key);
    }

    static {
        PATH_RESOURCE = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources";
        PATH_RESOURCE_DATA = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "data";
        ENV =  SerenityInfrastructure.getEnvironmentVariables();
    }
}
