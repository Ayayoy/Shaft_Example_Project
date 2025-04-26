package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P02_Home_Page {
    SHAFT.GUI.WebDriver driver;

    // Constructor

    public P02_Home_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By MenListBtn = By.xpath("(//a[@href=\"#Men\"])");
    By TShirtBtn = By.xpath("//a[@href=\"/category_products/3\" and contains(.,'Tshirts ')]");
    // Methods
    @Step("Navigate to Product Page")
    public P03_Product_Page navigateToProducts() {
        driver.element().click(MenListBtn)
                .click(TShirtBtn);
        return new  P03_Product_Page(driver);
    }
}
