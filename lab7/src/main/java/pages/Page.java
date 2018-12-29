package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

abstract public class Page {
    WebDriver driver;
    String url;

    Page(WebDriver driver) {
        this.driver = driver;
        this.url = driver.getCurrentUrl();
    }

    private boolean isOpened() {
        return driver.getCurrentUrl().equals(url);
    }

    public String getURL() {
        return url;
    }

    public void open() {
        if (!isOpened())
            driver.get(url);
    }

    public void takeScreenCapture(String filename){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try { FileUtils.copyFile(scrFile, new File(filename)); }
        catch (IOException e) { System.err.println(e.getMessage()); }
    }
}
