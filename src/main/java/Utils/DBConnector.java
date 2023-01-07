package Utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class DBConnector {
    PropertiesLoader loader = new PropertiesLoader();
    public Connection getConnection() throws IOException {
        Properties properties = loader.getProperties();

        String userName = (String) properties.get("userName");
        String password = (String) properties.get("password");
        String url = (String) properties.get("url");

        Connection con = null;
        try{
             Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, userName, password);
            if(con !=null) {
                System.out.println("Соединение с БД установлено.");
            }else{
                System.out.println("Соединение с БД не установлено...");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return con;
    }
}
