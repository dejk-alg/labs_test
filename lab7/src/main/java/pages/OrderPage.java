package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webElements.Button;
import webElements.TextField;

public class OrderPage extends Page {

    private TextField fullNameField;
    private TextField phoneField;
    private Button nextButton;

    public OrderPage(WebDriver driver) {
        super(driver);
        fullNameField = new TextField(driver.findElement(By.id("reciever_name")));
        phoneField = new TextField(driver.findElement(By.id("reciever_phone")));
    }

    public void setFullName(String name) {
        fullNameField.enterText(name);
    }

    public void setPhoneField(String phone) {
        phoneField.enterText(phone);
    }

    public boolean contactsFilled() {
        try { Thread.sleep(2000); }
        catch (InterruptedException e) {System.err.println(e.getMessage());}
        nextButton = new Button(driver.findElement(By.xpath("//*[@id=\"step_contacts\"]/div/div[1]/div[2]/div/span/button")));
        return nextButton.isEnabled();
    }

    public FinalOrderPage clickNext() {
        try { Thread.sleep(2000); }
        catch (InterruptedException e) {System.err.println(e.getMessage());}
        nextButton = new Button(driver.findElement(By.xpath("//*[@id=\"step_contacts\"]/div/div[1]/div[2]/div/span/button")));
        nextButton.click();
        return new FinalOrderPage(driver);
    }
}
