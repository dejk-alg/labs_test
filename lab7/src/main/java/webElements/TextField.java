package webElements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextField extends MyWebElement {
    public TextField(WebElement element) {
        super(element);
    }

    public void enterText(String text) {
        element.sendKeys(text);
    }

    public void clear() {
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }
}
