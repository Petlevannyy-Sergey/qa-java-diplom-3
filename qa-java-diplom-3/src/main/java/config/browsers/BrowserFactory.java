package config.browsers;

import org.openqa.selenium.WebDriver;

public interface BrowserFactory {
    WebDriver createDriver();
}
