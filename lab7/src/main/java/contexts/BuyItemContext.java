package contexts;

import pages.BasketPage;
import pages.FinalOrderPage;
import pages.OrderPage;

public class BuyItemContext {
    private String fullname;
    private String phone;
    private OrderPage orderPage;

    public BuyItemContext(String fullname, String phone) {
        this.fullname = fullname;
        this.phone = phone;
    }

    public void confirmItem(BasketPage basketPage) {
        orderPage = basketPage.buy();
    }

    public void fillNameAndPhone() {
        orderPage.setFullName(fullname);
        orderPage.setPhoneField(phone);
    }

    public boolean contactsFilled() {
        return orderPage.contactsFilled();
    }

    public FinalOrderPage clickNext() {
        return orderPage.clickNext();
    }

    public void takeScreenCapture(String filename) {
        orderPage.takeScreenCapture(filename);
    }
}
