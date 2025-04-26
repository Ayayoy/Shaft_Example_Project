package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_Product_Page {
    SHAFT.GUI.WebDriver driver;

    // Constructor

    public P03_Product_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By ProductCard = By.xpath("//div[@class=\"productinfo text-center\"]");
    By ContinueBtn = By.xpath("(//button[@data-dismiss=\"modal\"])");
    By ViewCartBtn = By.xpath("(//a[@href='/view_cart'])[1]");
    // Methods
    @Step("add products its price less than 1000")
    public P03_Product_Page addProducts() {
        List<WebElement> products = driver.getDriver().findElements(ProductCard);

        try {
            for (int i = 0; i < products.size(); i++) {
                WebElement productElement = products.get(i);
                int productPrice = Integer.parseInt(productElement.findElement
                        (By.xpath(".//h2")).getText().replaceAll("[^0-9]", ""));
                System.out.println("Price of Product " + (i+1) );
                if (productPrice < 1000){
                    driver.element().click(By.xpath("(//div[@class=\"productinfo text-center\"])["+(i+1)+"]/a"))
                            .click(ContinueBtn);
                }
                System.out.println("added Product with Price" + productPrice + "to the cart");
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    @Step("verify veiw cart Products")
    public void productVerification(){
        driver.element().scrollToElement(ViewCartBtn).click(ViewCartBtn).
                and().browser().captureScreenshot();
    }

}
