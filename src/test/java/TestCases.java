import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class TestCases {
    public RequestSpecification reqSpec;


    @BeforeClass
    public void Setup(){
        baseURI="https://api.themoviedb.org/3/";
        reqSpec = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzYWI4ZTY1YjQzYWU4OGEyYjYwNDlkNDdmM2I2YWRjMSIsIm5iZiI6MTczMTc4ODYyMi4xMzIxMTI3LCJzdWIiOiI2NzM0ZmUwMWEzYjUzNjFhMDY1MjBhNGEiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.OaeIPbK5N_C-5cT-WMnasgxB1eY08X1Ru1narQcVa9k")
                .setContentType(ContentType.JSON)
                .build();

    }


    @Test
    public void TestExample() {
        given()

                .when()

                .then()
                .log().body()
        ;

    }

    @Test
    public void Upcoming(){

        given()
                .spec(reqSpec)
                .when()
                .get("movie/upcoming")

                .then()
                .log().body()
                .statusCode(200)
                ;

    }

    @Test
    public void Movie(){

        given()
                .spec(reqSpec)
                .when()
                .get("search/movie?query=Inception")

                .then()
                .log().body()
                .statusCode(200)
        ;

    }

    @Test
    public void Details(){

        given()
                .spec(reqSpec)
                .when()
                .get("movie/550")

                .then()
                .log().body()
                .statusCode(200)
        ;
    }


    @Test
    public void DeleteRating(){

        given()
                .spec(reqSpec)
                .when()
                .delete("movie/550/rating")

                .then()
                .log().body()
                .statusCode(200)
        ;
    }
}


