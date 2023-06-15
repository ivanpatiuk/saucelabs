package com.saucelabs.testconfig;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@Log4j2
public class RestAssuredController {

    public Response getByRestAssured(final String path){
        log.debug("Querying by RestAssured: {}", path);
        return RestAssured.get(path);
    }

    public Response getByRestAssured(final String path, final String body) {
        log.debug("Querying by RestAssured: {}, with body: {}", path, body);
        return RestAssured
                .given()
                .baseUri(path)
                .body(body)
                .get();
    }
}
