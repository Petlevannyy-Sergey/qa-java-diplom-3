package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

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

    public void setEmail(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    public void setCredentials(User user){
        setEmail(user.getEmail());
        setPassword(user.getPassword());
    }
}
