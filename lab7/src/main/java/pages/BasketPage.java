package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.Button;
import webElements.PlainText;

public class BasketPage extends Page {

    private Button buyButton;
    private PlainText overallPrice;

    BasketPage(WebDriver driver) {
        super(driver);
        buyButton = new Button(driver.findElement(By.id("popup-checkout")));
        overallPrice = new PlainText(driver.findElement(By.xpath("//*[@id=\"cart_payment_info\"]/div/span[2]/span[1]")));
    }

    public int getPrice() {
        return Integer.parseInt(overallPrice.getText());
    }

    public OrderPage buy() {
        buyButton.click();
        return new OrderPage(driver);
    }
}
