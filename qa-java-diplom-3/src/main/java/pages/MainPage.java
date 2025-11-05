package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class MainPage {
    private final WebDriver webDriver;
    public static final String url = "https://stellarburgers.education-services.ru/";

    // Кнопка "Войти в аккаунт"
    private final By btnLogin = By.xpath(".//button[text()='Войти в аккаунт']");

    //Кнопка "Личный кабинет"
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickLoginButton() {
        webDriver.findElement(btnLogin).click();
    }

    public void clickAccountButton() {
        webDriver.findElement(accountButton).click();
    }
}
