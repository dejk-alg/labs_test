import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RozetkaTest {

    private static void enterMinPrice(WebDriver driver, Integer minPrice){
        driver.findElement(By.xpath("//*[@id=\"price[min]\"]")).sendKeys(minPrice.toString());
        driver.findElement(By.xpath("//*[@id=\"submitprice\"]")).click();
    }

    private static Integer getMinPriceValue(WebDriver driver){
        return Integer.valueOf(driver.findElement(By.xpath("//*[@id=\"price[min]\"]")).getAttribute("value"));
    }

    private static ArrayList<Integer> getPriceList(WebDriver driver){
        try {
            Thread.sleep(200);
            List<WebElement> elements = driver.findElements(By.xpath("//*[@class='g-price-uah']"));
            Thread.sleep(200);
            ArrayList<Integer> priceList = new ArrayList<Integer>();
            for (WebElement elem : elements) priceList.add(Integer.valueOf(elem.getText().replaceAll("\\D+", "")));
            return priceList;
        }
        catch (InterruptedException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Test
    public void checkDiapasonMin(){

        WebDriver driver = TestLab6.initializeChromeDriver();
        driver.get("https://hard.rozetka.com.ua/videocards/c80087/");
        Integer setPriceValue = 5000;
        enterMinPrice(driver,setPriceValue);
        Integer minPriceRealValue = getMinPriceValue(driver);

        driver.close();
        driver.quit();
        Assert.assertEquals(minPriceRealValue, setPriceValue);
    }

    @Test
    public void compareActualValuesToMin(){

        WebDriver driver = TestLab6.initializeChromeDriver();
        driver.get("https://hard.rozetka.com.ua/videocards/c80087/");
        Integer setPriceValue = 5000;
        enterMinPrice(driver,setPriceValue);
        List<Integer> priceList = getPriceList(driver);

        driver.close();
        for (Integer price: priceList)
            Assert.assertTrue(price >= setPriceValue);
    }
}
