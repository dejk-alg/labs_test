package webElements;

import org.openqa.selenium.WebElement;

public class Button extends MyWebElement {
    public Button(WebElement element) {
        super(element);
    }

    public void click() {
        element.click();
    }

    public boolean isEnabled() {
        return element.isEnabled();
    }
}
