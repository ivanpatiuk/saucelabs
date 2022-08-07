package config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import config.pojo.Driver;
import config.pojo.WebDriver;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyModel {

    @JsonProperty("webDriver")
    private WebDriver webDriver;

    @JsonProperty("driver")
    private Driver driver;
}
