package steps;

import container.DataContainer;
import io.cucumber.java.ru.Если;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static Utils.MapsUtil.exctractSubMap;
import java.util.Map;

public class RestSteps {
    DataContainer dataContainer;
    public RestSteps(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    @Если("отправить REST запрос методом POST c параметрами и сохранить ответ в переменную '(.*)'$")
    public void sendRequestAndSaveResponseToVariable(String varName, Map<String, String> cucumberValues) {
        Map<String, String> headers = exctractSubMap(cucumberValues, "header");
        var json = dataContainer.resolveVariable(cucumberValues.get("JSON"));
        var url = dataContainer.resolveVariable(cucumberValues.get("URL"));
        var jwt = dataContainer.resolveVariable(cucumberValues.get("header Authorization"));
        headers.put("Authorization", " Bearer " + jwt);
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
    }
}
