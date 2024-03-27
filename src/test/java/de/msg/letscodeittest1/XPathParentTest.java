package de.msg.letscodeittest1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathParentTest {

    private WebDriver driver;
    private final String baseUrl = "https://www.letskodeit.com/practice";


    public WebDriver webdriverSetup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();

        return driver;
    }


    @Test
    public void testFindNameElements() throws InterruptedException {
        driver = webdriverSetup();
        driver.get(baseUrl);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String expectedElements = "Apple\nOrange\nPeach";
        // kopierter xpath von Apple: //*[@id="multiple-select-example"]/option[1]
        WebElement allElementsInSelectBox = driver.findElement(By.xpath("//option[@value='apple']//parent::select"));

        String actualElements = allElementsInSelectBox.getText();
        Assertions.assertEquals(expectedElements,actualElements);

        //close Fire fox
//        driver.close();
    }

}
