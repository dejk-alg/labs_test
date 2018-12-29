package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemInfo extends MyWebElement {
    private PlainText priceText;
    private Button buyButton;

    public ItemInfo(WebElement element) {
        super(element);
        PlainText priceText = new PlainText(element.findElement(By.className("g-price")));
        buyButton = new Button(element.findElement(By.name("topurchasesfromcatalog")));
    }

    public int getPrice() {
        return Integer.parseInt(priceText.getText());
    }

    public void buyItem() {
        buyButton.click();
        try { Thread.sleep(1600); }
        catch (InterruptedException e) {System.err.println(e.getMessage());}
    }
}
