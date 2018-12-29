package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.ItemInfo;
import webElements.PlainText;
import webElements.PriceFilter;

public class CategoryPage extends Page {

    private PlainText headline;
    private PriceFilter priceFilter;


    CategoryPage(WebDriver driver) {
        super(driver);
        headline = new PlainText(driver.findElement(By.xpath("//*[@id=\"title_page\"]/div/div/div[2]/h1")));
        priceFilter = new PriceFilter(driver.findElement(By.id("sort_price")));
    }

    public String getHeadline() {
        return headline.getText();
    }

    public void setPriceRange(int minValue, int maxValue) {
        priceFilter.setPriceRange(minValue, maxValue);
    }

    public ItemInfo getItemByIndex(int ind) {
        return new ItemInfo(driver.findElement(By.xpath(String.format("//*[@id=\"catalog_goods_block\"]/div/div[%d]", ind))));
    }

    public BasketPage chooseItemByIndex(int ind) {
        getItemByIndex(ind).buyItem();
        return new BasketPage(driver);
    }
}
