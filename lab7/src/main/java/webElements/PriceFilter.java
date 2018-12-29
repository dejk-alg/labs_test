package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PriceFilter extends MyWebElement {
    private Button submitPriceButton;
    private TextField minPriceField;
    private TextField maxPriceField;

    public PriceFilter(WebElement element) {
        super(element);
        submitPriceButton = new Button((element.findElement(By.id("submitprice"))));
        minPriceField = new TextField(element.findElement(By.id("price[min]")));
        maxPriceField = new TextField(element.findElement(By.id("price[max]")));
    }

    public void enterMinPrice(int value) {
        minPriceField.clear();
        minPriceField.enterText(Integer.toString(value));
    }

    public void enterMaxPrice(int value) {
        maxPriceField.clear();
        maxPriceField.enterText(Integer.toString(value));
    }

    public void applyFilter() {
        submitPriceButton.click();
    }

    public void setPriceRange(int minValue, int maxValue) {
        enterMinPrice(minValue);
        enterMaxPrice(maxValue);
        applyFilter();
        try { Thread.sleep(200); }
        catch (InterruptedException e) {System.err.println(e.getMessage());}
    }
}
