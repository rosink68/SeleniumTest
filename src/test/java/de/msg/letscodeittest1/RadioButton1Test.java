package de.msg.letscodeittest1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButton1Test {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.letskodeit.com/practice";

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    public void webdriverSetup() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.letskodeit.com/practice";

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testRadioButton() {
    //    webdriverSetup();

        String expectElement = "benz";
        // xpath: //*[@id="benzradio"]
        // WebElement element = driver.findElement(By.xpath("//input[@id='benzradio']"));
        // wenn eine id angegeben ist IMMER id nehmen
        WebElement element = driver.findElement(By.id("benzradio"));
        element.click();

        // irgendwie gibt er hier nicht Benz zurück
        String actualElement = element.getText();
        System.out.println("value: " + element.getAttribute("value"));
        Assertions.assertEquals(expectElement, element.getAttribute("value"));
        Assertions.assertTrue(element.isSelected());

    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
