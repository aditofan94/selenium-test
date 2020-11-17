package search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleSearchTest {

    @Test
    public void simpleSearchWithOneKeyWord () {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://testfasttrackit.info/selenium-test/");

        String searchKeyword = "vase";
        driver.findElement(By.id("search")).sendKeys(searchKeyword + Keys.ENTER);

        System.out.println("Pressed Enter");

        List<WebElement> productNames = driver.findElements(By.cssSelector("h2.product-name a"));

        System.out.println("Stored " + productNames.size() + " product names");

        for (WebElement productName : productNames) {
            assertThat("Some product names do not contain the keyword",
                    productName.getText(), containsString(searchKeyword.toUpperCase()));
        }

    }
}
