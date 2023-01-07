package steps;

import Utils.DBConnector;
import container.DataContainer;
import io.cucumber.java.ru.Также;
import java.io.IOException;


public class DBSteps {
    DataContainer dataContainer;
    DBConnector dbConnector = new DBConnector();
    public DBSteps(DataContainer dataContainer)  {
        this.dataContainer = dataContainer;
    }

 @Также("^установить соединение с БД '(.*)'$")
 public void getConnectToDb(String dbName) throws IOException {
     dataContainer.storeVariable(dbName, "Название БД");
     dbConnector.getConnection();
 }
}
