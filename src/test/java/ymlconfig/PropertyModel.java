package ymlconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ymlconfig.models.Driver;
import ymlconfig.models.WebDriver;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyModel {

    @JsonProperty("webDriver")
    private WebDriver webDriver;

    @JsonProperty("driver")
    private Driver driver;

    @JsonProperty("testSiteAddress")
    private String testSiteAddress;
}
