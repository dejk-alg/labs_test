package contexts;

import pages.CategoryPage;
import pages.MainPage;

public class CategoryContext {
    private CategoryPage categoryPage;
    private String categoryName;
    private String subcategoryName;

    public CategoryContext(String categoryName, String subcategoryName) {
        this.categoryName = categoryName;
        this.subcategoryName = subcategoryName;
    }

    public CategoryPage openCategoryPage(MainPage mainPage) {
        categoryPage = mainPage.openCategoryPage(categoryName, subcategoryName);
        return categoryPage;
    }

    public String getHeadline() {
        return categoryPage.getHeadline();
    }
}
