import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPostmanEcho {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {

        given().
                when().
                get("/get").

                then().
                statusCode(200).
                body("headers.host", equalTo("postman-echo.com")).
                body("headers.x-forwarded-proto", equalTo("http")).
                body("headers.connection", equalTo("close")).
                body("headers.accept", equalTo("*/*")).
                body("url", equalTo("http://postman-echo.com/get"));
    }

    @Test
    public void testPostRowText() {
        String requestBody = "{ \"test\": \"value\" }";

        given().
                header("Content-Type", "text/plain").
                body(requestBody).
                when().
                post("/post").

                then().
                statusCode(200).
                body("data", equalTo("{ \"test\": \"value\" }")).
                body("headers.host", equalTo("postman-echo.com")).
                body("headers.x-forwarded-proto", equalTo("http")).
                body("headers.connection", equalTo("close")).
                body("headers.x-forwarded-port", equalTo("443")).
                body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1")).
                body("headers.accept", equalTo("*/*")).
                body("json", equalTo(null)).
                body("url", equalTo("http://postman-echo.com/post"));
    }

    @Test
    public void testPostFormData() {

        given().
                header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").
                header("Accept-Encoding", "gzip, deflate, br").
                formParam("foo1", "bar1").
                formParam("foo2", "bar2").
                when().
                post("/post").

                then().
                statusCode(200).
                body("headers.host", equalTo("postman-echo.com")).
                body("headers.x-forwarded-proto", equalTo("http")).
                body("headers.connection", equalTo("close")).
                body("headers.x-forwarded-port", equalTo("443")).
                body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8")).
                body("headers.accept", equalTo("*/*")).
                body("form.foo1", equalTo("bar1")).
                body("form.foo2", equalTo("bar2")).
                body("json.foo1", equalTo("bar1")).
                body("json.foo2", equalTo("bar2")).
                body("url", equalTo("http://postman-echo.com/post"));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given().
                header("Content-Type", "text/plain").
                body(requestBody).
                when().
                put("/put").

                then().
                statusCode(200).
                body("data", equalTo("This is expected to be sent back as part of response body.")).
                body("headers.host", equalTo("postman-echo.com")).
                body("headers.x-forwarded-proto", equalTo("http")).
                body("headers.connection", equalTo("close")).
                body("headers.x-forwarded-port", equalTo("443")).
                body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1")).
                body("headers.accept", equalTo("*/*")).
                body("json", equalTo(null)).
                body("url", equalTo("http://postman-echo.com/put"));
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given().
                header("Content-Type", "text/plain").
                body(requestBody).
                when().
                patch("/patch").

                then().
                statusCode(200).
                body("data", equalTo("This is expected to be sent back as part of response body.")).
                body("headers.host", equalTo("postman-echo.com")).
                body("headers.x-forwarded-proto", equalTo("http")).
                body("headers.connection", equalTo("close")).
                body("headers.x-forwarded-port", equalTo("443")).
                body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1")).
                body("headers.accept", equalTo("*/*")).
                body("json", equalTo(null)).
                body("url", equalTo("http://postman-echo.com/patch"));
    }

    @Test
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given().
                header("Content-Type", "text/plain").
                body(requestBody).
                when().
                delete("/delete").

                then().
                statusCode(200).
                body("data", equalTo("This is expected to be sent back as part of response body.")).
                body("headers.host", equalTo("postman-echo.com")).
                body("headers.x-forwarded-proto", equalTo("http")).
                body("headers.connection", equalTo("close")).
                body("headers.x-forwarded-port", equalTo("443")).
                body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1")).
                body("headers.accept", equalTo("*/*")).
                body("json", equalTo(null)).
                body("url", equalTo("http://postman-echo.com/delete"));
    }
}
