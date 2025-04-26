package pages;
import com.shaft.driver.SHAFT;
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
    public void logInSteps(String userName , String Password) {
        driver.element().type(EmailInput ,userName).
                type(PasswordInput, Password).
                click(LoginButton);
    }
}
