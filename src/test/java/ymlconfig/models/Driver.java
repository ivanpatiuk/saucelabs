package ymlconfig.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Driver {
    @JsonProperty("chrome-driver")
    private String chromeDriver;
}
