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

    //Кнопка "Булки"
    private final By bunsButton = By.xpath(".//span[text()='Булки']");

    //Кнопка "Соусы"
    private final By saucesButton = By.xpath(".//span[text()='Соусы']");

    //Кнопка "Начинки"
    private final By fillingsButton = By.xpath(".//span[text()='Начинки']");

    // Вкладка "Булки" активна
    private final By bunsActiveTab = By.xpath(".//div[contains(@class, 'current') and contains(.//span, 'Булки')]");

    // Вкладка "Соусы" активна
    private final By saucesActiveTab = By.xpath(".//div[contains(@class, 'current') and contains(.//span, 'Соусы')]");

    // Вкладка "Начинки" активна
    private final By fillingsActiveTab = By.xpath(".//div[contains(@class, 'current') and contains(.//span, 'Начинки')]");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickLoginButton() {
        webDriver.findElement(btnLogin).click();
    }

    public void clickAccountButton() {
        webDriver.findElement(accountButton).click();
    }

    public void clickBunsButton(){
        webDriver.findElement(bunsButton).click();
    }

    public void clickSaucesButton(){
        webDriver.findElement(saucesButton).click();
    }

    public void clickFillingButton(){
        webDriver.findElement(fillingsButton).click();
    }

    public boolean bunsTabIsActive() {
        return webDriver.findElement(bunsActiveTab).isEnabled();
    }

    public boolean saucesTabIsActive() {
        return webDriver.findElement(saucesActiveTab).isEnabled();
    }

    public boolean fillingsTabIsActive() {
        return webDriver.findElement(fillingsActiveTab).isEnabled();
    }
}
