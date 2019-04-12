import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void testParametrizedTest(){
        logger.debug("second test");
        assertTrue(true);
    }

    @Tag("aaa")
    @Test
    @DisplayName("😱")
    public void testThree(){
        logger.debug("terceiro test");
        assertTrue(true);
    }
}
