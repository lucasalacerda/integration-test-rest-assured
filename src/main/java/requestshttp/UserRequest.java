package requestshttp;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserRequest implements Request {

    protected Response response;
    protected String urlBase;
    protected String token;

    public UserRequest(String urlBase, String token) {
        this.urlBase = urlBase;
        this.token = token;
    }

    @Override
    public Response getById(int id) {
        response = given()
                .when()
                .get(urlBase+"/users/"+id)
                .then().log().ifError().extract().response();

        return response;
    }

    @Override
    public Response getAll() {
        response = given()
                .when()
                .header("", "")
                .get(urlBase+"/users")
                .then().extract().response();

        return response;
    }

    @Override
    public Response post(Response response) {
        return null;
    }
}
