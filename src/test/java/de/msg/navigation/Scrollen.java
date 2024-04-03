package de.msg.navigation;

import de.msg.pageobjects.DummyRegistration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Scrollen {

    private static WebDriver driver;
    private JavascriptExecutor javascriptExecutor;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://usersnap.com/blog/long-scrolling-websites-tips-best-practices/");
    }

    @Test
    public void scrollingTest() {

        WebElement footerElement = driver.findElement(By.cssSelector("footer.site-footer"));

        javascriptExecutor = (JavascriptExecutor) driver;

        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", footerElement);

    }

    @AfterAll
    public static void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
