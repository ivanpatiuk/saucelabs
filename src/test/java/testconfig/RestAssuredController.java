package testconfig;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestAssuredController {

    public Response getByRestAssured(final String path){
        return RestAssured.get(path);
    }

    public Response getByRestAssured(final String path, final String body) {
        return RestAssured
                .given()
                .baseUri(path)
                .body(body)
                .get();
    }
}
