package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Wrapper {


    public static void waitForLoading(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static Properties loadProperties() {
        Properties property = new Properties();
        String propertyFilePath ="src/main/resources/testdata/config.properties";
        try (FileInputStream input = new FileInputStream(propertyFilePath)) {
            property.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }


    public static String get(String propertyName){
        return loadProperties().getProperty(propertyName).trim();
    }

}
