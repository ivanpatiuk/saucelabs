package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WebDriverEnum {
    WebDriverChrome("webdriver.chrome.driver");

    private String driver;
}
