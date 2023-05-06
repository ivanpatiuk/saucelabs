package com.saucelabs.ymlconfig.models;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class Main {
    @Test
    void method1() {
        log.debug("test");
    }

    @Test
    void method1methodmethod1methodmethod1methodmethod1method() {
        log.debug("test");
    }
}
