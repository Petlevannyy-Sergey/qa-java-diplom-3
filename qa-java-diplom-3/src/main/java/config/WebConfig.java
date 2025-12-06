package config;

import config.browsers.ChromeBrowser;
import config.browsers.FirefoxBrowser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.InputStream;
import java.util.Properties;

public class WebConfig {
    private static Properties loadPropertiesFromFile() {
        try (InputStream fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties")) {
            Properties props = new Properties();
            props.load(fis);
            return props;
        } catch (Exception e) {
            throw new RuntimeException("Error reading config.properties", e);
        }
    }

    private static String detectCurrentBrowser() {
        Properties props = loadPropertiesFromFile();
        if (!props.isEmpty() && props.containsKey("browser")) {
            return props.getProperty("browser").trim();
        } else {
            throw new IllegalStateException("No browser selected in config.properties!");
        }
    }

    public static WebDriver runDriver() {
        String browser = detectCurrentBrowser();

        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeBrowser().createDriver();
            case "firefox":
                return new FirefoxBrowser().createDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browser);
        }
    }
}
