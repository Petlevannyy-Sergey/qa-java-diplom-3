package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private final WebDriver webDriver;

    //Кнопка "Войти" под формой восстановления пароля
    private final By loginButton = By.xpath(".//a[text()='Войти']");

    private final By recoverPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");

    public PasswordRecoveryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    public void clickRecoverPasswordButton() {
        webDriver.findElement(recoverPasswordButton).click();
    }
}
