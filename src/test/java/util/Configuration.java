package util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by twer on 2017/6/29.
 */
public class Configuration {

    public static String driver;
    public static String url;
    public static String username;
    public static String password;


    static {
        final Properties properties = new Properties();
        try {
            final FileReader reader = new FileReader(Configuration.class.getResource("/application.properties").getFile());
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("spring.datasource.driver-class-name");
        url = properties.getProperty("spring.datasource.url");
        username = properties.getProperty("spring.datasource.username");
        password = properties.getProperty("spring.datasource.password");
    }


}
