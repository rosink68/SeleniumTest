package de.msg.Tutorials;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitImplExample {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

    }

    @Test
    public void waitImplExampleTest () {
        driver.findElement(By.cssSelector("#start button")).click();

        // OHNE einem explizite Wait wird textFinish (also Hello World!) NICHT ausgegeben
        //String textFinish = driver.findElement(By.id("finish")).getText();
        // MIT einem explizite Wait wird textFinish (also Hello World!) ausgegeben
        String textFinish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish"))).getText();

        System.out.println(textFinish);

    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
