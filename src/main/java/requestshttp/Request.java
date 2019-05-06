package requestshttp;

import io.restassured.response.Response;

public interface Request {

    Response getById(int id);
    Response getAll();
    Response post(Response response);

}
