package requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserRequest {

    Response response;

    public Response getUser() {

        response = given()
                .when()
                .header("", "")
                .get("/")
                .then().extract().response();

        return response;
    }

    public Response getUserById(int id) {

        response = given()
                .when()
                .get("/${id}")
                .then().extract().response();

        return response;
    }

}
