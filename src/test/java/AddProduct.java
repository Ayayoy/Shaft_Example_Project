import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01_LogIn_Page;

public class AddProduct {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testJson;
    @Step("navigate to product page and add Products less than 1000$")
    @Test
    public void addProductToCart() {
        new P01_LogIn_Page(driver).logInSteps
                (testJson.getTestData("UserName"), testJson.getTestData("Password"))
                .navigateToProducts()
                .addProducts()
                .productVerification();
    }

    @BeforeClass
    public void setUp() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://www.automationexercise.com/login");
        testJson = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData() + "testdata.json");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
