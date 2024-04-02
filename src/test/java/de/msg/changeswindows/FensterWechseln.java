package de.msg.changeswindows;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class FensterWechseln {

    public static WebDriver driver;
    public static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.letskodeit.com/practice";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }

    @Test
    public void fensterWechselnTest() {
        WebElement openWindowButton = driver.findElement(By.id("openwindow"));
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);

        openWindowButton.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for(String window : windowHandles) {

             if(!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                System.out.println(window);

                Assertions.assertNotEquals(window,mainWindow);

                WebElement searchField = driver.findElement(By.xpath("//input[@id='search']"));
                searchField.sendKeys("JavaScript");
                System.out.println("Gesucht wird nach: " + searchField.getAttribute("value"));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver.close();
                break;
            }
        }

        driver.switchTo().window(mainWindow);
        WebElement checkBox = driver.findElement(By.id("bmwcheck"));
        checkBox.click();
    }


    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
