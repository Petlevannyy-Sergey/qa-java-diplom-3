package login;

import config.WebConfig;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;
import user.User;
import user.UserActions;
import utils.Generators;

import static org.junit.Assert.assertTrue;

public class LoginTests {
    private WebDriver driver;
    User user;
    String accessToken;
    MainPage mainPage;
    LoginPage loginPage;
    AccountPage accountPage;

    @Before
    public void setup() {
        user = Generators.getUser();
        Response response = UserActions.create(user);
        accessToken = UserActions.getAccessToken(response);
        driver = WebConfig.runChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Test
    @DisplayName("Авторизация на главной странице")
    public void loginOnMainPageIsSuccess() {
        // Arrange

        // Act
        driver.navigate().to(MainPage.url);
        mainPage.clickLoginButton();
        loginPage.setCredentials(user);
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        boolean result = accountPage.isActive();

        // Assert
        assertTrue("Некорректно работает авторизация на главной странице", result);
    }

    @Test
    @DisplayName("Авторизация через личный кабинет")
    public void LoginUsingAccountIsSuccess() {
        // Arrange

        // Act
        driver.navigate().to(MainPage.url);
        mainPage.clickAccountButton();
        loginPage.setCredentials(user);
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        boolean result = accountPage.isActive();

        // Assert
        assertTrue("Некорректно работает авторизация через личный кабинет", result);
    }

    @Test
    @DisplayName("Авторизация через кнопку на форме регистрации")
    public void LoginFromRegistrationPageIsSuccess() {
        // Arrange
        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Act
        driver.navigate().to(MainPage.url);
        mainPage.clickAccountButton();
        registrationPage.clickRegisterLink();
        registrationPage.clickLoginLink();
        loginPage.setCredentials(user);
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        boolean result = accountPage.isActive();

        // Assert
        assertTrue("Некорректно работает авторизация через кнопку на форме регистрации", result);
    }

    @Test
    @DisplayName("Авторизация через кнопку в форме восстановления пароля")
    public void LoginFromPasswordRecoveryPageIsSuccess() {
        // Arrange
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);

        // Act
        driver.navigate().to(MainPage.url);
        mainPage.clickAccountButton();
        passwordRecoveryPage.clickRecoverPasswordLink();
        passwordRecoveryPage.clickLoginLink();
        loginPage.setCredentials(user);
        loginPage.clickLoginButton();
        mainPage.clickAccountButton();
        boolean result = accountPage.isActive();

        // Assert
        assertTrue("Некорректно работает авторизация через кнопку на форме регистрации", result);
    }

    @After
    public void teardown() {
        UserActions.delete(accessToken);
        driver.quit();
    }
}
