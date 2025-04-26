package pages;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
public class P01_LogIn_Page {
    private SHAFT.GUI.WebDriver driver;

    // Constructor

    public P01_LogIn_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By EmailInput = By.xpath("//input [@data-qa=\"login-email\"]");
    By PasswordInput = By.xpath("//input [@data-qa=\"login-password\"]");
    By LoginButton = By.xpath("//button[@data-qa=\"login-button\"]");
    //Methods
    @Step("log in with valid Email and Password")
    public P02_Home_Page logInSteps(String userName , String Password) {
        driver.element().type(EmailInput ,userName).
                type(PasswordInput, Password).
                click(LoginButton);
        return new P02_Home_Page(driver);
    }
}
