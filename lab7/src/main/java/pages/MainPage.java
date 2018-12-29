package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.Hyperlink;

public class MainPage extends Page {

    static private final String main_url = "https://rozetka.com.ua/";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public CategoryPage openCategoryPage(String categoryName, String subcategoryName) {
        open();
        Hyperlink categoryLinkElement  = new Hyperlink(driver.findElement(By.linkText(categoryName)));
        categoryLinkElement.click();
        Hyperlink subcategoryLinkElement  = new Hyperlink(driver.findElement(By.linkText(subcategoryName)));
        subcategoryLinkElement.click();
        return new CategoryPage(driver);
    }
}
