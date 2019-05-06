import com.google.gson.Gson;
import io.restassured.response.Response;
import models.User;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.*;
import requestshttp.UserRequest;

@Tag("userTests")
@DisplayName("User's class test")
public class UserTest {

    final static Logger logger = Logger.getLogger(UserTest.class);
    private static User user;
    private static UserRequest userRequest = new UserRequest("http://5cd0353cd4a78300147bde4b.mockapi.io", "");
    private static Response response;

    @BeforeAll()
    public static void initialize() {
        PropertyConfigurator.configure("log4j.properties");
        response = userRequest.getById(1);
        user = new Gson().fromJson(response.getBody().prettyPrint(), User.class);
        logger.info("Prepare Log");
    }

    @Test
    @DisplayName("Test if the name is correct")
    public void test_if_name_is_correct() {
        logger.info("Name testing");

        Assertions.assertEquals(user.getFirstName(), "Chad", "firstName not equals");
        Assertions.assertEquals(user.getLastName(), "Daniel", "lastName not equals");
    }

    @Test
    @DisplayName("Test if status code is 200")
    public void test_status_code_get_by_id() {
        logger.info("status code testing");

        Assertions.assertEquals(response.getStatusCode(), 200, "status code not equals to 200");
    }
}
