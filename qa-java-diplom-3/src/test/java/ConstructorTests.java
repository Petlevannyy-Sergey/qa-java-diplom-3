import config.WebConfig;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class ConstructorTests {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setup() {
        driver = WebConfig.runChromeDriver();
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Переключение на вкладку 'Булки'")
    public void SwitchToBunTabIsSuccess() {
        // Arrange

        // Act
        driver.navigate().to(MainPage.url);
        mainPage.clickFillingButton();
        mainPage.clickBunsButton();

        // Assert
        Assert.assertTrue("Некорректное переключение на вкладку 'Булки'", mainPage.bunsTabIsActive());
    }

    @Test
    @DisplayName("Переключение на вкладку 'Соусы'")
    public void SwitchToSauceTabIsSuccess() {
        // Arrange

        // Act
        driver.navigate().to(MainPage.url);
        mainPage.clickSaucesButton();

        // Assert
        Assert.assertTrue("Некорректное переключение на вкладку 'Соусы'", mainPage.saucesTabIsActive());
    }

    @Test
    @DisplayName("Переключение на вкладку 'Начинки'")
    public void SwitchToFillingTabIsSuccess() {
        // Arrange

        // Act
        driver.navigate().to(MainPage.url);
        mainPage.clickFillingButton();

        // Assert
        Assert.assertTrue("Некорректное переключение на вкладку 'Начинки'", mainPage.fillingsTabIsActive());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
