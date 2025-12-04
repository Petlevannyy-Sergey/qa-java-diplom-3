package pages;

import io.qameta.allure.Step;
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
    private final By loginLink = By.xpath(".//a[text()='Войти']");

    //Поле "Email"
    private final By emailInput = By.xpath(".//label[text()='Email']/../input");

    //Поле "Пароль"
    private final By passwordInput = By.xpath(".//label[text()='Пароль']/../input");

    //Поле "Имя"
    private final By nameInput = By.xpath(".//label[text()='Имя']/../input");

    // Ошибка "Некорректный пароль"
    private final By wrongPasswordError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Нажатие на ссылку регистрации")
    public void clickRegisterLink() {
        webDriver.findElement(registerLink).click();
    }

    @Step("Нажатие на кнопку регистрации")
    public void clickRegisterButton() {
        webDriver.findElement(registerButton).click();
    }

    @Step("Нажатие на ссылку входа")
    public void clickLoginLink() {
        webDriver.findElement(loginLink).click();
    }

    @Step("Ввод email")
    public void setEmail(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void setPassword(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Ввод имени")
    public void setName(String name) {
        webDriver.findElement(nameInput).sendKeys(name);
    }

    @Step("Ввод учетных данных пользователя")
    public void setCredentials(User user) {
        setName(user.getName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
    }

    @Step("Проверка ошибок ввода пароля")
    public boolean hasPasswordError() {
        return webDriver.findElement(wrongPasswordError).isEnabled();
    }
}
