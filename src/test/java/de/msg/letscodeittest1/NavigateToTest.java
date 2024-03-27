package de.msg.letscodeittest1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NavigateToTest {
    private static WebDriver driver;
    private static String baseUrl;

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
    public void testNavigateToByXpath() throws InterruptedException {
        String titel1 = driver.getTitle();
        System.out.println("Der Titel der Seite 1 ist " + titel1);
        String url1 = driver.getCurrentUrl();
        System.out.println("Die URL der Seite 1 ist " + url1);

        WebElement element = driver.findElement(By.xpath("//div[contains(@class,'wikipedia-logo')]"));
        element.click();

        String titel2 = driver.getTitle();
        System.out.println("Der Titel der Seite 2 ist " + titel2);
        String url2 = driver.getCurrentUrl();
        System.out.println("Die URL der Seite 2 ist " + url2);

        driver.navigate().back();

        driver.navigate().forward();
    }

    @Test
    public void testNavigateToByUrl() throws InterruptedException {
        String titel1 = driver.getTitle();
        System.out.println("Der Titel der Seite 1 ist " + titel1);
        String url1 = driver.getCurrentUrl();
        System.out.println("Die URL der Seite 1 ist " + url1);

        driver.navigate().to("https://de.wikipedia.org/wiki/Wikipedia:Hauptseite");

        String titel2 = driver.getTitle();
        System.out.println("Der Titel der Seite 2 ist " + titel2);
        String url2 = driver.getCurrentUrl();
        System.out.println("Die URL der Seite 2 ist " + url2);

        driver.navigate().back();
        driver.navigate().forward();

        // Quellcode der Seite ausgeben
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        driver.quit();
    }
}
