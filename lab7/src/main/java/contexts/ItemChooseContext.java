package contexts;

import pages.BasketPage;
import pages.CategoryPage;
import webElements.ItemInfo;

public class ItemChooseContext {
    private CategoryPage categoryPage;
    private ItemInfo chosenItem;
    private int minPrice;
    private int maxPrice;
    private int itemIndex;

    public ItemChooseContext(int minPrice, int maxPrice, int itemIndex) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.itemIndex = itemIndex;
    }

    public void setCategoryPage(CategoryPage categoryPage) {
        this.categoryPage = categoryPage;
    }

    public void chooseItem() {
        categoryPage.setPriceRange(minPrice, maxPrice);
        chosenItem = categoryPage.getItemByIndex(itemIndex);
    }

    public int getPrice() {
        return chosenItem.getPrice();
    }

    public BasketPage buyItem() {
        return categoryPage.chooseItemByIndex(itemIndex);
    }
}
