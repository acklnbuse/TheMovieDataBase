import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestCases {
    @Test
    public void TestExample()
    {
        given()

                .when()

                .then()
                .log().body()
        ;

    }

}
