package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver webDriver;

    //Кнопка "Зарегистрироваться"
    private final By registerButton = By.xpath(".//a[text()='Зарегистрироваться']");

    //Кнопка "Войти" под формой регистрации
    private final By loginButton = By.xpath(".//a[text()='Войти']");

    public RegistrationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickRegisterButton() {
        webDriver.findElement(registerButton).click();
    }

    public void clickLoginButton(){
        webDriver.findElement(loginButton).click();
    }
}
