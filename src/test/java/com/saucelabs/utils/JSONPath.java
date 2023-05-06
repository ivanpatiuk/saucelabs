package com.saucelabs.utils;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JSONPath {

    public static String getByJsonPath(final Response response, final String path) {
        return JsonPath.read(response.getBody().asString(), "$." + path);
    }
}
