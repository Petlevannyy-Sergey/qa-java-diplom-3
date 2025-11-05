package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class AccountPage {
    private final WebDriver webDriver;

    public AccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Ожидание загрузки страницы профиля
    public boolean isActive() {
        String url = "https://stellarburgers.education-services.ru/account/profile";
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(url));
        return Objects.equals(webDriver.getCurrentUrl(), url);
    }
}