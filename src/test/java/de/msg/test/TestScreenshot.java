package de.msg.test;

import de.msg.helper.MyScreenshot;
import org.checkerframework.checker.units.qual.A;
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

public class TestScreenshot {

     public static WebDriver driver;
     private static WebDriverWait wait;

    @BeforeAll
     public static void setUp() {
         System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
         driver = new ChromeDriver();
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         driver.manage().window().maximize();

         driver.get("https://www.google.com/");
     }

     @Test
     public void testScreenshot() {

         // Nutzungsbedingungen ablehnen
         driver.findElement(By.id("W0wltc")).click();
         // auf Google Webseite Suchbegrif eingeben
         WebElement searchField = driver.findElement(By.id("APjFqb"));
         searchField.sendKeys("Testautomatisierung - Gewusst wie");
         // Enter Sucheingabe <== alternativ kann auch auf den Suchen-Button mit der id="btnK" geklickt werden
         searchField.submit();

         // ich benutze hier den WaitDriver, weil ansonsten ein Screenscot ohne Inhalt gemacht wird
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hdtb-tls")));

         MyScreenshot.makeScreenShot(driver);
     }


     @AfterAll
    public static void tearDown() throws InterruptedException {
         Thread.sleep(2000);
         driver.quit();
     }
}
