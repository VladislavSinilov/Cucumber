package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

    public Properties getProperties() throws IOException {
        FileInputStream fis = new FileInputStream("src/main/resources/environments/ct.properties");
        Properties properties = new Properties();
        properties.load(fis);
        return properties;
    }

    public void readFromConf(){
        String str = ConfigProvider.HOST;
        System.out.println(str);
    }
}
