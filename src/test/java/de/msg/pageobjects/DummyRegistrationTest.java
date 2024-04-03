package de.msg.pageobjects;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DummyRegistrationTest {

    private static WebDriver driver;
    private static DummyRegistration registration;

    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        driver = new ChromeDriver();
        registration = new DummyRegistration(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String baseUrl = "https://way2automation.com/way2auto_jquery/";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().window().maximize();

        driver.get(baseUrl);
    }

    @Test
    public void registrationTest() {
        registration.typeName("Hans Huckebein");
        registration.typePhone("0123/456789");
        registration.typeEmail("Hans.Huckebein@abc.de");
        registration.selectCountry("Germany");
        registration.typeCity("Berlin");
        registration.typeUsername("HansiHucki");
        registration.typePassword("123abc456");
        registration.clickSubmitButtonTest();

        String textExpected = "This is just a dummy form, you just clicked SUBMIT BUTTON";
        // alternativ: $x("//p[contains(text(),'This is just')]")
        // ich verwende hier das explizite wait, da ansonsten der Text nicht ausgegeben wird
        String textActual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert"))).getText();
        System.out.println("textExpected: "+ textExpected);
        System.out.println("textActual: "+ textActual);

        Assertions.assertEquals(textExpected, textActual);
    }

    @AfterAll
    public static void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
