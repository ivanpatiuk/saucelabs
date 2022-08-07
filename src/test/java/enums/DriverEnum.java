package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DriverEnum {
    ChromeDriver("C:/Patiuk/DriversJava/chromedriver.exe");

    private String driver;
}
