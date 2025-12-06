package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class MainPage {
    private final WebDriver webDriver;
    public static final String url = "https://stellarburgers.education-services.ru/";

    // Кнопка "Войти в аккаунт"
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");

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

    @Step("Нажатие на кнопку входа")
    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }

    @Step("Нажатие на кнопку входа в личный кабинет")
    public void clickAccountButton() {
        webDriver.findElement(accountButton).click();
    }

    @Step("Нажатие на вкладку 'Булки'")
    public void clickBunsButton(){
        webDriver.findElement(bunsButton).click();
    }

    @Step("Нажатие на вкладку 'Соусы'")
    public void clickSaucesButton(){
        webDriver.findElement(saucesButton).click();
    }

    @Step("Нажатие на вкладку 'Начинки'")
    public void clickFillingButton(){
        webDriver.findElement(fillingsButton).click();
    }

    @Step("Проверка, что вкладка 'Булки' активна")
    public boolean bunsTabIsActive() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(bunsActiveTab)))
                .isEnabled();
    }

    @Step("Проверка, что вкладка 'Соусы' активна")
    public boolean saucesTabIsActive() {
        return webDriver.findElement(saucesActiveTab).isEnabled();
    }

    @Step("Проверка, что вкладка 'Начинки' активна")
    public boolean fillingsTabIsActive() {
        return webDriver.findElement(fillingsActiveTab).isEnabled();
    }

    @Step("Проверка, что страница загружена")
    public boolean isActive(){
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(url));
        return Objects.equals(webDriver.getCurrentUrl(), url);
    }
}
