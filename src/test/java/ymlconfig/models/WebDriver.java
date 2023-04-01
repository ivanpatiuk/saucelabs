package ymlconfig.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WebDriver {
    @JsonProperty("chrome-web-driver")
    private String chromeWebDriver;
}
