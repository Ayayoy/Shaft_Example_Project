import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01_LogIn_Page;

public class AddProduct {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testJson;

    @Test
    public void addProductToCart() {
        new P01_LogIn_Page(driver).logInSteps
                (testJson.getTestData("UserName"), testJson.getTestData("Password"));
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
