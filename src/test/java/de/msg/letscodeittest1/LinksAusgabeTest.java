package de.msg.letscodeittest1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinksAusgabeTest {

    public static WebDriver driver;
    public static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.wikipedia.de/";

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }

    @Test
    public void linkAusgabeTest() {

        List<WebElement> linkListe = driver.findElements(By.tagName("a"));

        for (WebElement link : linkListe) {
          System.out.println(link.getAttribute("href"));
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
