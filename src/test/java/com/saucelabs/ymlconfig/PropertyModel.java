package com.saucelabs.ymlconfig;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.saucelabs.ymlconfig.models.UsersCredentials;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyModel {
    @JsonProperty("test-site-address")
    private String testSiteAddress;
    @JsonProperty("users-credentials")
    private UsersCredentials usersCredentials;
}
