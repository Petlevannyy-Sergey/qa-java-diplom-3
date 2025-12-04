package user;

import config.Specification;
import config.URIs;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserActions {
    @Step("Создание пользователя")
    public static Response create(User user) {
        return given()
                .spec(Specification.requestSpecification())
                .and()
                .body(user)
                .when()
                .post(URIs.USER);
    }

    @Step("Получение токена доступа из ответа сервера")
    public static String getAccessToken(Response response) {
        return response.then().extract().path("accessToken").toString();
    }

    @Step("Удаление пользователя")
    public static void delete(String accessToken) {
        given()
                .spec(Specification.requestSpecification())
                .and()
                .header("Authorization", accessToken)
                .when()
                .delete(URIs.USER);
    }
}
