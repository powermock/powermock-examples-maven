package org.powermock.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static Boolean enabled;

    public static boolean isEnabled() {
        if (enabled == null){
            loadFromProperties();
        }
        return enabled;
    }

    private static void loadFromProperties() {
        Properties properties = readProperties();
        enabled = "true".equals(properties.getProperty("enabled"));
    }

    private static Properties readProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("some.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
