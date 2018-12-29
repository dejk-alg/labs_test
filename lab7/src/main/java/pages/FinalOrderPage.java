package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.Button;
import webElements.PlainText;

public class FinalOrderPage extends Page {

    private Button approveButton;
    private PlainText totalPriceText;

    public FinalOrderPage(WebDriver driver) {
        super(driver);
        approveButton = new Button(driver.findElement(By.id("make-order")));
    }

    public String getPrice() {
        return totalPriceText.getText();
    }

    public boolean orderPossible() {
        return approveButton.isEnabled();
    }
}
