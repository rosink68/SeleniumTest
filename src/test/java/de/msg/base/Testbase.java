package de.msg.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Testbase {

    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
            driver = new ChromeDriver();
            String baseUrl = "https://www.letskodeit.com/practice";

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            driver.get(baseUrl);
        }
    }

    @AfterAll
    public static void tearDown() {
        wait2000();
        if (driver != null) {
            driver.quit();
        }
    }


    /*
     * The helper class makes it possible to track the actions on the user interface.
     */
    public static void wait2000() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
