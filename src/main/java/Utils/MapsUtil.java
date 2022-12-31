package Utils;

import java.util.HashMap;
import java.util.Map;

public class MapsUtil {
    public static Map<String, String> exctractSubMap(Map<String, String> cucumberData, String parameterName) {
        Map<String, String> resultMap = new HashMap<>();
        for (Map.Entry<String, String> entry : cucumberData.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (key.startsWith(parameterName)) {
                String[] parts = key.split(" ");
                resultMap.put(parts[1], value);
            }
        }
        return resultMap;
    }
}
