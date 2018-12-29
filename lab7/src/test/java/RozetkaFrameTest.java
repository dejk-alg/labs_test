import contexts.BuyItemContext;
import contexts.CategoryContext;
import contexts.ItemChooseContext;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.BasketPage;
import pages.CategoryPage;
import pages.FinalOrderPage;
import pages.MainPage;

public class RozetkaFrameTest {
    /*@Test
    public void fullOrderTest() {
        WebDriver driver = DriverInitializer.initializeDriver();
        MainPage mainPage = new MainPage(driver);

        String categoryName = "Ноутбуки и компьютеры";
        String subcategoryName = "Видеокарты";

        int minPrice = 5000;
        int maxPrice = 10000;
        int itemIndex = 2;

        String fullname = "Peter Smith";
        String phone = "+380500000000";

        CategoryContext categoryContext = new CategoryContext(categoryName, subcategoryName);
        CategoryPage categoryPage = categoryContext.openCategoryPage(mainPage);
        categoryPage.takeScreenCapture(String.format("Category page for %s.png", subcategoryName));

        ItemChooseContext itemChooseContext = new ItemChooseContext(minPrice, maxPrice, itemIndex);
        itemChooseContext.setCategoryPage(categoryPage);
        itemChooseContext.chooseItem();
        BasketPage basketPage = itemChooseContext.buyItem();
        categoryPage.takeScreenCapture(String.format("Chosen %s item.png", subcategoryName));

        BuyItemContext buyItemContext = new BuyItemContext(fullname, phone);
        buyItemContext.confirmItem(basketPage);
        buyItemContext.fillNameAndPhone();

        FinalOrderPage finalOrderPage = buyItemContext.clickNext();
        finalOrderPage.takeScreenCapture(String.format("Order %s item.png", subcategoryName));
        Assert.assertTrue(finalOrderPage.orderPossible());

        driver.close();
        driver.quit();
    }*/

    /*@Test
    public void checkCategoryName() {
        WebDriver driver = DriverInitializer.initializeDriver();
        MainPage mainPage = new MainPage(driver);

        String categoryName = "Ноутбуки и компьютеры";
        String subcategoryName = "Мониторы";

        CategoryContext categoryContext = new CategoryContext(categoryName, subcategoryName);
        CategoryPage categoryPage = categoryContext.openCategoryPage(mainPage);
        String headline = categoryPage.getHeadline();
        driver.close();
        driver.quit();
        Assert.assertEquals(headline, subcategoryName);
    }*/

    @Test
    public void enterWrongPhoneNumber() {
        WebDriver driver = DriverInitializer.initializeDriver();
        MainPage mainPage = new MainPage(driver);

        String categoryName = "Ноутбуки и компьютеры";
        String subcategoryName = "Видеокарты";

        int minPrice = 7000;
        int maxPrice = 23000;
        int itemIndex = 1;

        String fullname = "Andriy Kovalenko";
        String phone = "+239345784";

        CategoryContext categoryContext = new CategoryContext(categoryName, subcategoryName);
        CategoryPage categoryPage = categoryContext.openCategoryPage(mainPage);

        ItemChooseContext itemChooseContext = new ItemChooseContext(minPrice, maxPrice, itemIndex);
        itemChooseContext.setCategoryPage(categoryPage);
        itemChooseContext.chooseItem();
        BasketPage basketPage = itemChooseContext.buyItem();

        BuyItemContext buyItemContext = new BuyItemContext(fullname, phone);
        buyItemContext.confirmItem(basketPage);
        buyItemContext.fillNameAndPhone();
        boolean contactsFilled = buyItemContext.contactsFilled();
        buyItemContext.takeScreenCapture("Wrong phone number.png");
        driver.close();
        driver.quit();

        Assert.assertFalse(contactsFilled);
    }
}
