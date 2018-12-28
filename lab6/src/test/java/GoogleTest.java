import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoogleTest {

    private class SearchOutput
    {
        String link;
        int pageNumber;

        SearchOutput(String link, int pageNumber) {
            this.link = link;
            this.pageNumber = pageNumber;
        }
    }

    private static void createSearchRequest(WebDriver driver, String request){
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys(request);
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")).click();
    }

    private static ArrayList<String> getSearchLinks(WebDriver driver) {

        List<WebElement> webElements = driver.findElements(By.xpath("//*[@class='r']/a"));

        ArrayList<String> links = new ArrayList<String>();
        for (WebElement webElement: webElements) links.add(webElement.getAttribute("href"));

        return links;
    }

    private static String getLinkToNextPage(WebDriver driver){
        String xpath = "//*[@id=\"pnnext\"]";
        return TestLab6.getLinkByXPath(driver, xpath);
    }

    private static String findString(List<String> links,String target){
        for (String link: links) if (link.toLowerCase().contains(target.toLowerCase())) return link;
        return null;
    }


    private void captureAllPages(WebDriver driver, String request) throws IOException {
        driver.get("https://www.google.com/");
        createSearchRequest(driver,request);

        int pageIndex = 1;
        TestLab6.takeScreenCapture(driver, String.format("request page %d.png", pageIndex));
        String nextPageLink = getLinkToNextPage(driver);

        while (nextPageLink != null) {
            TestLab6.takeScreenCapture(driver, String.format("request page %d.png", pageIndex));
            driver.get(nextPageLink);

            nextPageLink = getLinkToNextPage(driver);
            pageIndex++;
        }
    }


    private SearchOutput findCompanyBySearchRequest(String request, String companyURL) throws IOException {

        WebDriver driver = TestLab6.initializeChromeDriver();

        driver.get("https://www.google.com/");
        createSearchRequest(driver,request);

        String targetLink;

        int pageIndex = 1;
        String nextPageLink = getLinkToNextPage(driver);
        targetLink = findString(getSearchLinks(driver),companyURL);

        while (nextPageLink != null && targetLink == null) {
            driver.get(nextPageLink);

            nextPageLink = getLinkToNextPage(driver);
            pageIndex++;

            targetLink = findString(getSearchLinks(driver),companyURL);
        }

        if (targetLink != null) {
            TestLab6.takeScreenCapture(driver, String.format("result at page %d.png", pageIndex));
            driver.get(targetLink);
            TestLab6.takeScreenCapture(driver, String.format("target %s.png", companyURL));
        }

        else captureAllPages(driver, request);

        driver.close();

        return new SearchOutput(targetLink, pageIndex);
    }

    @Test
    public void searchForFirstPageCompany() throws IOException {
        SearchOutput searchOutput = findCompanyBySearchRequest("mobilenetv2 architecture", "ai.googleblog.com");
        Assert.assertNotEquals(searchOutput.link,null);
        Assert.assertEquals(searchOutput.pageNumber, 1);
    }

    @Test
    public void searchForFurtherPageCompany() throws IOException {
        SearchOutput searchOutput = findCompanyBySearchRequest("kedr livanskiy closer", "itunes.apple.com");
        Assert.assertNotEquals(searchOutput.link,null);
        Assert.assertNotEquals(searchOutput.pageNumber, 1);
    }

    @Test
    public void searchForAbsentCompany() throws IOException {
        SearchOutput searchOutput = findCompanyBySearchRequest("ssd yolo inception", "yolo.com");
        Assert.assertNull(searchOutput.link);
    }
}