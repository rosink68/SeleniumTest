package de.msg.letscodeittest1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PracticePageLetsCodeItTest {


    private WebDriver driver;
    private final String baseUrlTutorial = "https://letskodeit.teachable.com/p/practice";
    private final String baseUrl = "https://www.letskodeit.com/practice";


    public WebDriver webdriverSetup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();

        return driver;
    }


    @Test
    public void testWebsiteTitle() {

        driver = webdriverSetup();

        String expectedTitle = "Practice Page";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle,actualTitle);

        //close Fire fox
        driver.close();
    }

    @Test
    public void testHeaderH1() {
        driver = webdriverSetup();

        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String expectHeaderH1 = "Practice Page";
        WebElement header1 = driver.findElement(By.tagName("h1"));
        String actualHeaderH1 = header1.getText();

        Assertions.assertEquals(expectHeaderH1,actualHeaderH1);

        //close Fire fox
        //       driver.close();

    }

}
