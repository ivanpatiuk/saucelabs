package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class TestConfiguration {
    private static final String CONFIGURATION_FILE_PATH = "src/test/resources/tests-config.yml";
    private static PropertyModel properties;

    public static PropertyModel getProperties() {
        if (properties == null) {
            properties = readProperties();
        }
        return properties;

    }
    private static PropertyModel readProperties() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            mapper.findAndRegisterModules();
            PropertyModel propertyModel = mapper.readValue(new File(CONFIGURATION_FILE_PATH), PropertyModel.class);
            return propertyModel;
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
