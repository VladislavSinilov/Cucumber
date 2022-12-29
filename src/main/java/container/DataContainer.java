package container;

import java.util.HashMap;
import java.util.Map;

public class DataContainer {

    private Map<String, String> container = new HashMap<>();


    public void storeVariable(String varName, String text){
        container.put(varName, text);
    }

    public String resolveVariable(String varNameOrText){
        if(varNameOrText.startsWith("@")){
            if(container.containsKey(varNameOrText)){
                return container.get(varNameOrText);
            } else {
                throw new RuntimeException("Значения" + varNameOrText + "нет в контейнере");
            }
        }
      else return varNameOrText;
    }

 //   picocontainer - почитать


}
