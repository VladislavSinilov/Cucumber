package steps;


import container.DataContainer;
import io.cucumber.java.ru.Дано;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.Map;

import static Utils.MapsUtil.exctractSubMap;

public class JwtSteps {
    DataContainer dataContainer;

    public JwtSteps(DataContainer dataContainer) {
        this.dataContainer = dataContainer;
    }

    @Дано("^отправить запрос на получение JWT токена и сохранить в переменную '(.*)'$")
    public void putParmsOfToken(String varName, Map<String, String> jwtData) {
        Map<String, String> formParms = exctractSubMap(jwtData, "formParam");
        var url = dataContainer.resolveVariable(jwtData.get("URL"));
        Response response = RestAssured.given()
                .log().all()
                .accept(ContentType.JSON)
                .contentType(ContentType.URLENC)
                .formParams(formParms)
                .when()
                .post(url)
                .then()
                .log().all()
                .extract()
                .response();
        JsonPath jp = new JsonPath(response.asString());
        var jwt = jp.getString("access_token");
        dataContainer.storeVariable(varName, jwt);
    }
}
