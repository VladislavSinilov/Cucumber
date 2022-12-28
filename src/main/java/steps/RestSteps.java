package steps;

import container.DataContainer;
import cucumber.api.java.ru.Если;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class RestSteps {
    DataContainer dataContainer;

    public RestSteps(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    @Если("отправить REST запрос методом POST c параметрами и сохранить ответ в переменную '(.*)'$")
    public void sendRequestAndSaveResponseToVariable(String varName, Map<String, String> cucumberValues) {
        Map<String, String> headers = exctractSubMap(cucumberValues, "header");
        String json = dataContainer.resolveVariable(cucumberValues.get("JSON"));
        String url = dataContainer.resolveVariable(cucumberValues.get("URL"));
        Response response = RestAssured.given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(json)
                .when()
                .post(url)
                .then()
                .log().all()
                .extract()
                .response();
        System.out.println(response.getBody().asString());
    }

    public Map<String, String> exctractSubMap(Map<String, String> cucumberData, String parameterName) {
        Map<String, String> resultMap = new HashMap<>();
        for (Map.Entry<String, String> entry : cucumberData.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.startsWith(parameterName)) {
                String[] parts = key.split(" ");
                resultMap.put(parts[1], value);
            }
        }
        return resultMap;
    }
}
