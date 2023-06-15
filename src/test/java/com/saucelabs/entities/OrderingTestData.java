package com.saucelabs.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;

@AllArgsConstructor
@Getter
public class OrderingTestData {
    private String orderingName;
    private boolean reversed;
    private By by;
}
