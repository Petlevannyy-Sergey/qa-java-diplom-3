package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class AccountPage {
    private final WebDriver webDriver;
    private final String url = "https://stellarburgers.education-services.ru/account/profile";

    public AccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Ожидание загрузки страницы профиля
    public boolean isActive() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(this.url));
        return Objects.equals(webDriver.getCurrentUrl(), this.url);
    }
}