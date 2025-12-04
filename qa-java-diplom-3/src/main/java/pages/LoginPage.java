package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;

import java.time.Duration;

public class LoginPage {
    private final WebDriver webDriver;

    //Поле "Email"
    private final By emailInput = By.xpath(".//label[text()='Email']/../input");

    //Поле "Пароль"
    private final By passwordInput = By.xpath(".//label[text()='Пароль']/../input");

    //Кнопка "Войти"
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Заполнение поля email")
    public void setEmail(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }

    @Step("Заполнение поля пароль")
    public void setPassword(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажатие на кнопку входа")
    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    @Step("Заполнение логина и пароля")
    public void setCredentials(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
    }

    @Step("Ожидание загрузки страницы авторизации")
    public void waitUntilLoaded() {
        String url = "https://stellarburgers.education-services.ru/login";
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(url));
    }
}
