package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver webDriver;

    //Кнопка "Войти" под формой восстановления пароля
    private final By loginLink = By.xpath(".//a[text()='Войти']");

    // Кнопка "Восстановить пароль"
    private final By recoverPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public PasswordRecoveryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickLoginLink() {
        webDriver.findElement(loginLink).click();
    }

    public void clickRecoverPasswordLink() {
        webDriver.findElement(recoverPasswordLink).click();
    }
}
