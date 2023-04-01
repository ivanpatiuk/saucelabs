package ymlconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import ymlconfig.models.Driver;
import ymlconfig.models.UsersCredentials;
import ymlconfig.models.WebDriver;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyModel {
    @JsonProperty("web-driver")
    private WebDriver webDriver;
    @JsonProperty("driver")
    private Driver driver;
    @JsonProperty("test-site-address")
    private String testSiteAddress;
    @JsonProperty("users-credentials")
    private UsersCredentials usersCredentials;
}
