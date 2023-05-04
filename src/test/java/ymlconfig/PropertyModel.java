package ymlconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ymlconfig.models.UsersCredentials;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyModel {
    @JsonProperty("test-site-address")
    private String testSiteAddress;
    @JsonProperty("users-credentials")
    private UsersCredentials usersCredentials;
}
