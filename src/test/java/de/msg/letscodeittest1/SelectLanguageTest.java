package de.msg.letscodeittest1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SelectLanguageTest {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.wikipedia.org/";

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }

    @Test
    public void testSelectLanguage() throws InterruptedException {
        WebElement selectElement = driver.findElement(By.id("searchLanguage"));
        Select selectLanguage = new Select(selectElement);
        selectLanguage.selectByValue("az");
        Thread.sleep(2000);
        selectLanguage.selectByIndex(0);
        Thread.sleep(2000);
        selectLanguage.selectByVisibleText("Dansk");
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
