package de.msg.letscodeittest1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ComboBoxTest {

    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        // System.setProperty("webdriver.chrome.driver","C:\\Users\\rosink\\IdeaProjects\\SeleniumTest\\src\\main\\resources\\chromedriver1.exe");
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver1.exe");
        // Alternative, wenn Chromedriver.exe unter executables abgelegt werden kann
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver1.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.letskodeit.com/practice";

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

   @Test
    public void testSelectClass() {
        //webdriverSetup();

        String expectedText = "Honda";
        WebElement hondaElement = driver.findElement(By.xpath("//option[@value='honda']"));
        hondaElement.click();
        String actualText = hondaElement.getText();

        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    public void testSelectElement() throws InterruptedException {
        WebElement selectElement = driver.findElement(By.id("carselect"));
        Select selectCar = new Select(selectElement);
        selectCar.selectByValue("honda");
        Thread.sleep(2000);
        selectCar.selectByIndex(0);
        Thread.sleep(2000);
        selectCar.selectByVisibleText("Benz");
    }

    @Test
    public void testSelectOption() {
        WebElement selectElement = driver.findElement(By.id("carselect"));
        Select selectCar = new Select(selectElement);
        List<WebElement> listCars = selectCar.getOptions();

        for (WebElement car : listCars) {
            System.out.println(car.getText());
        }
    }

    @Test
    public void testSelectBenz() {
        boolean benzSelected = false;
        WebElement selectElement = driver.findElement(By.id("carselect"));
        Select selectCar = new Select(selectElement);
        List<WebElement> listCars = selectCar.getOptions();

        for (WebElement car : listCars) {

            if(car.getAttribute("value").equals("benz")) {
                car.click();
                benzSelected = true;
            }
        }

        Assertions.assertTrue(benzSelected);
    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
