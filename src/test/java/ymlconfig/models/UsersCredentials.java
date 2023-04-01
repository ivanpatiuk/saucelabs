package ymlconfig.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UsersCredentials {
    @JsonProperty("standard-user-name")
    private String standardUserName;
    @JsonProperty("locked-out-user-name")
    private String lockedOutUserName;
    @JsonProperty("problem-user-name")
    private String problemUserName;
    @JsonProperty("performance_glitch_user-name")
    private String performanceGlitchUserName;
    @JsonProperty("password")
    private String password;
}
