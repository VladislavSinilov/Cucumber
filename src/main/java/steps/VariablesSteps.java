package steps;

import container.DataContainer;
import io.cucumber.java.ru.Дано;

public class VariablesSteps {

    DataContainer dataContainer;
    public VariablesSteps(DataContainer dataContainer){
        this.dataContainer = dataContainer;

    }
    @Дано("^получить значение переменной '(.*)'$")
    public void getVariableValue(String varName) {
        String v = dataContainer.resolveVariable(varName);
        System.out.println(v);
    }

    @Дано("^сохранить ответ в переменную '(.*)' значение:$")
    public void saveResponseIntoTheVariable(String varName, String value) {
        dataContainer.storeVariable(varName, value);
    }
}
