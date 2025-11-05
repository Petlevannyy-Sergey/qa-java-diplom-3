package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class RegistrationPage {
    private final WebDriver webDriver;

    //Ссылка "Зарегистрироваться"
    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");

    //Кнопка "Зарегистрироваться"
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    //Кнопка "Войти" под формой регистрации
    private final By loginButton = By.xpath(".//a[text()='Войти']");

    //Поле "Email"
    private final By emailInput = By.xpath(".//label[text()='Email']/../input");

    //Поле "Пароль"
    private final By passwordInput = By.xpath(".//label[text()='Пароль']/../input");

    //Поле "Имя"
    private final By nameInput = By.xpath(".//label[text()='Имя']/../input");

    private final By wrongPasswordError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickRegisterLink() {
        webDriver.findElement(registerLink).click();
    }

    public void clickRegisterButton() {
        webDriver.findElement(registerButton).click();
    }

    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    public void setEmail(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }

    public void setName(String name) {
        webDriver.findElement(nameInput).sendKeys(name);
    }

    public void setCredentials(User user) {
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
    }

    public boolean hasPasswordError() {
        return webDriver.findElement(wrongPasswordError).isEnabled();
    }
}
