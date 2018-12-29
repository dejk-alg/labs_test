package webElements;

import org.openqa.selenium.WebElement;

abstract class MyWebElement {
    WebElement element;

    MyWebElement(WebElement element) {
        this.element = element;
    }

    public String getText() {
        return element.getText();
    }


}
