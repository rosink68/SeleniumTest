package de.msg.letscodeittest1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertSame;

public class XPathStartsWithTest {

    private WebDriver driver;
    private final String baseUrl = "https://www.letskodeit.com/practice";
    public WebDriver webdriverSetup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();

        return driver;
    }

    @Test
    public void testFindTextFindByXPathStartsWith() {
        driver = webdriverSetup();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String expectedText = "Multiple Select Example";
        // kopierter xpath: //*[@id="multi-select-example-div"]/fieldset/legend
        WebElement completeText = driver.findElement(By.xpath("//legend[starts-with(text(), 'Multiple')]"));
        String actualText = completeText.getText();

        Assertions.assertEquals(expectedText,actualText);

        //close Fire fox
        driver.close();
    }

    @Test
    public void testFindAttributeFindByXPathStartsWith() {
        driver = webdriverSetup();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // kopierter xpath der Select-Box: //*[@id="multiple-select-example"]
        WebElement selectBox = driver.findElement(By.xpath("//select[starts-with(@id, 'multiple')]"));

        //close Fire fox
        driver.close();
    }

}
