import config.WebConfig;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import user.User;
import utils.Generators;

import static org.junit.Assert.assertTrue;

public class RegistrationTests {
    private WebDriver driver;
    MainPage mainPage;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    User user;

    @Before
    public void setup() {
        driver = WebConfig.runDriver();
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        user = Generators.getUser();
    }

    @Test
    @Description("Проверка регистрации")
    @DisplayName("Регистрация пользователя с валидными данными")
    public void RegistrationIsSuccess() {
        // Arrange

        // Act
        driver.navigate().to(MainPage.url);
        mainPage.clickAccountButton();
        registrationPage.clickRegisterLink();
        registrationPage.setCredentials(user);
        registrationPage.clickRegisterButton();
        loginPage.waitUntilLoaded();
        loginPage.setCredentials(user);
        loginPage.clickLoginButton();
        boolean result = mainPage.isActive();

        // Assert
        assertTrue("Некорректно работает регистрация пользователя", result);
    }

    @Test
    @Description("Проверка регистрации")
    @DisplayName("Регистрация пользователя при некорректном вводе пароля")
    public void RegistrationWithIncorrectPasswordThrowsError() {
        // Arrange

        // Act
        driver.navigate().to(MainPage.url);
        mainPage.clickAccountButton();
        registrationPage.clickRegisterLink();
        user.setPassword("1234"); // Пароль 4 символа
        registrationPage.setCredentials(user);
        registrationPage.clickRegisterButton();
        boolean result = registrationPage.hasPasswordError();

        // Assert
        assertTrue("Возможен вход с некорректным паролем", result);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
