package webElements;

import org.openqa.selenium.WebElement;


public class Hyperlink extends MyWebElement {
    public Hyperlink(WebElement element) {
        super(element);
    }

    public void click() {
        element.click();
    }

}