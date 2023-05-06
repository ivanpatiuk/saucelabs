package com.saucelabs.ymlconfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class TestConfiguration {
    private static final String CONFIGURATION_FILE_PATH = "src/test/resources/tests-config.yml";
    private static PropertyModel properties;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();
            properties = mapper.readValue(new File(CONFIGURATION_FILE_PATH), PropertyModel.class);
            if(System.getProperty("tested-user-name") != null){
                properties.getUsersCredentials().setTestedUserName(System.getProperty("tested-user-name"));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static PropertyModel getProperties(){
        return properties;
    }
}
