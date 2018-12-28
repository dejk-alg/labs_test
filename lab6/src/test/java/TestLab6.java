import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

class TestLab6 {

    static WebDriver initializeChromeDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    static String getLinkByXPath(WebDriver driver, String xpath) {
        if (driver.findElements(By.xpath(xpath)).size() != 0) {
            return driver.findElement(By.xpath(xpath)).getAttribute("href");
        }
        return null;
    }

    static void takeScreenCapture(WebDriver driver, String filename) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(filename));
    }
}
