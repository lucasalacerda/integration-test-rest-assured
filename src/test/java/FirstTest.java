import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("A special test case")
public class FirstTest {

    final static Logger logger = Logger.getLogger(FirstTest.class);
    Response response;

    @BeforeAll
    public static void  before() {

        PropertyConfigurator.configure("log4j.properties");
        logger.debug("before all");
    }

    @BeforeEach
    void init() {

        logger.debug("before each");
    }


    @Tag("fast")
    @Test()
    @DisplayName("😱")
    public void testOne(){
        logger.debug("first test");
        assertTrue(true);
    }

    @Tag("slow")
    @Test
    @DisplayName("😱")
    public void testTwo(){
        logger.debug("second test");
        fail("):");
    }

    @Tag("aaa")
    @Test
    @DisplayName("😱")
    public void testThree(){
        logger.debug("terceiro test");
        fail("D:");
    }
}
